import brandIcon from "../images/bytebharat-icon.svg";
import loginHeroArt from "../images/login-hero.svg";
import overviewArt from "../images/overview-banner.svg";
import transfersArt from "../images/transfers.svg";
import cardsArt from "../images/cards.svg";
import statementsArt from "../images/statements.svg";
import insightsArt from "../images/insights.svg";
import { CasaModule, DepositsModule, LoansModule, PaymentsModule, ProfileModule, PasswordReset } from "./BankingModules.jsx";
import { useEffect, useMemo, useState } from "react";

const NAV_GROUPS = [
  { id: "products", label: "Products", icon: "wallet", items: ["Accounts", "Deposits", "Loans"] },
  { id: "payments", label: "Money movement", icon: "send", items: ["Payments", "Transfers", "Cards"] },
  { id: "services", label: "Services", icon: "chart", items: ["Statements", "Insights", "Profile"] }
];
const NAV_ICONS = { Overview: "home", Accounts: "wallet", Deposits: "chart", Loans: "file", Payments: "send", Transfers: "send", Cards: "card", Statements: "file", Insights: "chart", Profile: "edit" };
const WIDGETS = [
  { id: "balances", label: "Account balances" },
  { id: "quick", label: "Quick actions" },
  { id: "activity", label: "Recent activity" },
  { id: "spending", label: "Spending chart" },
  { id: "goal", label: "Savings goal" },
  { id: "insight", label: "Monthly insight" }
];
const DEFAULT_WIDGETS = WIDGETS.map((widget) => widget.id);
const money = (amount, currency = "INR") =>
  new Intl.NumberFormat("en-IN", { style: "currency", currency, maximumFractionDigits: 2 }).format(amount);

function Icon({ name, size = 18 }) {
  const common = { width: size, height: size, viewBox: "0 0 24 24", fill: "none", stroke: "currentColor", strokeWidth: 1.7, strokeLinecap: "round", strokeLinejoin: "round", "aria-hidden": true };
  const paths = {
    home: <><path d="m3 10 9-7 9 7v10a1 1 0 0 1-1 1h-5v-7H9v7H4a1 1 0 0 1-1-1V10Z" /></>,
    wallet: <><path d="M4 6.5A2.5 2.5 0 0 1 6.5 4H20v16H5a2 2 0 0 1-2-2V6.5ZM3 8h17M15 14h2" /></>,
    send: <><path d="m21 3-7.5 18-3.8-7.7L2 9.5 21 3ZM9.7 13.3 21 3" /></>,
    card: <><rect x="3" y="5" width="18" height="14" rx="2.5" /><path d="M3 10h18M7 15h3" /></>,
    file: <><path d="M7 3h7l5 5v13H7a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2Z" /><path d="M14 3v5h5M9 13h6m-6 4h6" /></>,
    chart: <><path d="M4 19V5m0 14h16M8 15l3-4 3 2 5-7" /></>,
    plus: <><path d="M12 5v14M5 12h14" /></>,
    bell: <><path d="M18 9a6 6 0 0 0-12 0c0 7-3 7-3 9h18c0-2-3-2-3-9ZM10 21h4" /></>,
    search: <><circle cx="10.8" cy="10.8" r="6.8" /><path d="m16 16 4 4" /></>,
    menu: <><path d="M4 6h16M4 12h16M4 18h16" /></>,
    edit: <><path d="m14 5 5 5M4 20l4.2-.8L20 7.4 16.6 4 4.8 15.8 4 20Z" /></>,
    close: <><path d="m6 6 12 12M18 6 6 18" /></>,
    sun: <><circle cx="12" cy="12" r="4" /><path d="M12 2v2m0 16v2M4.9 4.9l1.4 1.4m11.4 11.4 1.4 1.4M2 12h2m16 0h2M4.9 19.1l1.4-1.4M17.7 6.3l1.4-1.4" /></>,
    moon: <><path d="M20.5 15.5A8.5 8.5 0 0 1 8.5 3.5 8.5 8.5 0 1 0 20.5 15.5Z" /></>,
    arrow: <><path d="M5 12h14m-6-6 6 6-6 6" /></>
  };
  return <svg {...common}>{paths[name] || paths.home}</svg>;
}

function Brand() {
  return <div className="brand"><span className="brand-mark"><img src={brandIcon} alt="" /></span><span>BYTEBHARAT<small>FINANCIAL · DEMO</small></span></div>;
}

function Welcome({ onLogin, error, busy, onResetRequest, onResetComplete }) {
  const [userId, setUserId] = useState("");
  const [password, setPassword] = useState("");
  const [reset, setReset] = useState(false);
  const [resetMessage, setResetMessage] = useState("");
  return <main className="welcome">
    <section className="welcome-hero"><Brand /><div className="welcome-copy"><span className="eyebrow">Banking, made clear</span><h1>Your money.<br />Moving forward.</h1><p>A calm, connected place to see your accounts, make a plan, and stay on top of everyday finances.</p>        <img className="welcome-art" src={loginHeroArt} alt="Secure mobile banking illustration" />
<div className="security-note"><b>DEMO MODE</b>This prototype uses fictional data and has no connection to a bank or payment network.</div></div><span className="hero-caption">EVERYDAY BANKING · INTERACTIVE PROTOTYPE</span></section>
    <section className="welcome-panel"><div className="welcome-top"><span className="welcome-region"><i/> INDIA · DIGITAL BANKING</span><span>◎ English</span></div><div className="login-intro"><span className="eyebrow">THE BYTEBHARAT EXPERIENCE</span><h2>Banking that moves<br/>with you.</h2><p>Accounts, savings and payments in one connected place.</p></div>{reset ? <div className="welcome-card login-form"><PasswordReset onBack={(message)=>{setReset(false);setResetMessage(message);}} onRequest={onResetRequest} onComplete={onResetComplete} busy={busy}/></div> : <form className="welcome-card login-form" onSubmit={(event)=>{event.preventDefault();onLogin(userId,password);}}>
      <div className="welcome-symbol"><Icon name="wallet" size={24} /></div><h2>Sign in to ByteBharat</h2><p>Use your digital banking user ID and password.</p>
      <label>User ID<input autoComplete="username" required value={userId} onChange={(e)=>setUserId(e.target.value)} placeholder="Enter your user ID" /></label>
      <label>Password<input autoComplete="current-password" required type="password" value={password} onChange={(e)=>setPassword(e.target.value)} placeholder="Enter your password" /></label>
      {error && <div className="login-error" role="alert">{error}</div>}
      <button className="primary-btn full" disabled={busy}>{busy ? "Signing in…" : "Sign in"}<Icon name="arrow" size={16} /></button>
      <button type="button" className="link-btn forgot-link" onClick={()=>{setReset(true);setResetMessage("");}}>Forgot password?</button>
      <p className="demo-credentials">Demo: <b>demo</b> / <b>Demo@12345</b></p>
    </form>}<div className="login-highlights"><div><i>01</i><span><b>Accounts</b><small>Everyday banking</small></span></div><div><i>02</i><span><b>Grow</b><small>Deposits & insights</small></span></div><div><i>03</i><span><b>Payments</b><small>Made simple</small></span></div></div>{resetMessage&&<div className="welcome-card reset-message">{resetMessage}</div>}<p className="welcome-footer">Privacy · Security · Accessibility · ByteBharat is a fictional product</p></section>
  </main>;
}

function BalanceCard({ account, total }) {
  return <article className={"balance-card panel " + (total ? "balance-total" : "")}>
    <div className="balance-label">{total ? "Total available balance" : account.name}<span className={total ? "" : "balance-icon"}>{total ? "•••" : <Icon name={account.type === "Savings" ? "chart" : "wallet"} size={17} />}</span></div>
    <strong className="balance-amount">{money(account.balance, account.currency)}</strong>
    <span className="balance-meta">{total ? "Across " + account.count + " demo accounts" : account.type + " · " + account.maskedNumber}</span>
    {total && <span className="balance-change">↑ 2.4% this month</span>}
  </article>;
}

function Transactions({ rows, query = "" }) {
  const filtered = rows.filter((tx) => (tx.counterparty + tx.category + tx.note).toLowerCase().includes(query.toLowerCase()));
  if (!filtered.length) return <p className="empty-state">No matching demo transactions.</p>;
  return <div className="transaction-list">{filtered.map((tx) => <div className="transaction-row" key={tx.id}>
    <span className="transaction-icon">{tx.category === "Transfer" ? "↗" : tx.category === "Food & drink" ? "☕" : tx.category === "Transport" ? "◉" : tx.category === "Home & bills" ? "▣" : "▤"}</span>
    <span className="transaction-copy"><b>{tx.counterparty}</b><small>{tx.category} · {tx.status === "DEMO" ? "Demo transfer" : tx.note || "Posted"}</small></span>
    <time>{new Date(tx.occurredAt).toLocaleDateString("en-IN", { day: "2-digit", month: "short" })}</time>
    <strong className={Number(tx.amount) > 0 ? "credit" : ""}>{Number(tx.amount) > 0 ? "+" : "−"}{money(Math.abs(Number(tx.amount)))}</strong>
  </div>)}</div>;
}

function Spending({ insights }) {
  const max = Math.max(...insights.weeklySpend.map(Number), 1);
  return <section className="panel spending-panel">
    <div className="panel-heading"><div><strong>{money(insights.monthlySpend)}</strong><small>Sample spending this month</small></div><select aria-label="Spending period"><option>This month</option><option>Last month</option></select></div>
    <div className="bars" aria-label="Weekly spending chart">{insights.weeklySpend.map((amount, i) => <div className="bar-column" key={i}><div className="bar" style={{ height: Math.max(9, Number(amount) / max * 100) + "%" }} title={money(amount)} /><small>W{i + 1}</small></div>)}</div>
    <div className="chart-legend"><i /> Spending · sample totals</div>
  </section>;
}

function Widget({ id, data, query, setView }) {
  const accounts = data.accounts;
  const total = accounts.reduce((sum, account) => sum + Number(account.balance), 0);
  if (id === "balances") return <section className="widget balances-grid"><BalanceCard total account={{ balance: total, count: accounts.length }} />{accounts.map((account) => <BalanceCard key={account.id} account={account} />)}</section>;
  if (id === "quick") return <section className="widget quick-actions"><button className="quick-btn" onClick={() => setView("Transfers")}><Icon name="send" />Transfer money</button><button className="quick-btn" onClick={() => setView("Accounts")}><Icon name="plus" />Add account</button><button className="quick-btn" onClick={() => setView("Statements")}><Icon name="file" />View statements</button></section>;
  if (id === "activity") return <section className="widget panel activity-panel"><div className="panel-heading"><h2>Recent activity</h2><button className="link-btn" onClick={() => setView("Accounts")}>View accounts →</button></div><Transactions rows={data.transactions} query={query} /></section>;
  if (id === "spending") return <section className="widget"><Spending insights={data.insights} /></section>;
  if (id === "goal") {
    const pct = Math.min(100, Math.round(Number(data.insights.savedTowardGoal) / Number(data.insights.savingsGoal) * 100));
    return <section className="widget panel goal-panel"><div className="goal-ring" style={{ "--progress": pct + "%" }}><b>{pct}%</b></div><span className="eyebrow">SAVINGS GOAL</span><h2>Build your emergency fund</h2><p>Keep your goal visible and track your progress.</p><div className="progress-track"><i style={{ width: pct + "%" }} /></div><div className="goal-meta"><b>{money(data.insights.savedTowardGoal)} saved</b><span>{money(data.insights.savingsGoal)} goal</span></div></section>;
  }
  if (id === "insight") return <section className="widget panel insight-panel"><span className="tag">MONTHLY INSIGHT</span><h2>Your savings are growing</h2><p>You have made progress toward your sample savings goal this month.</p><button className="link-btn" onClick={() => setView("Insights")}>View insights →</button></section>;
  return null;
}

function Overview({ data, layout, query, setView }) {
  return <div className="widget-stack">{layout.order.filter((id) => layout.visible[id]).map((id) => <Widget id={id} key={id} data={data} query={query} setView={setView} />)}</div>;
}

function AccountsPage({ data, setView }) {
  return <><PageHeading eyebrow="YOUR MONEY, IN ONE PLACE" title="Accounts" subtitle="Balances and activity across your demo accounts." /><div className="two-column"><section className="panel page-panel"><h2>Deposit accounts</h2><p>All values are fictional sample data.</p>{data.accounts.map((account) => <div className="account-row" key={account.id}><span className="account-icon"><Icon name="wallet" /></span><span className="account-copy"><b>{account.name}</b><small>{account.type} · {account.maskedNumber}</small></span><strong>{money(account.balance, account.currency)}</strong></div>)}</section><section className="panel activity-panel"><div className="panel-heading"><h2>Recent activity</h2><button className="link-btn" onClick={() => setView("Transfers")}>Make a transfer →</button></div><Transactions rows={data.transactions.slice(0, 5)} /></section></div></>;
}

function TransfersPage({ data, onTransfer, busy }) {
  const [source, setSource] = useState(data.accounts[0]?.id || "");
  const [destination, setDestination] = useState(data.accounts[1]?.id || "");
  const [amount, setAmount] = useState("");
  const [memo, setMemo] = useState("");
  return <><PageHeading eyebrow="MOVE MONEY" title="Transfers" subtitle="Try a local demo transfer between sample accounts." art={transfersArt} /><div className="two-column"><form className="panel page-panel transfer-form" onSubmit={(event) => { event.preventDefault(); onTransfer({ sourceAccountId: source, destinationAccountId: destination, amount: Number(amount), memo }); }}>
    <h2>Make a transfer</h2><p>The mock backend updates balances in memory. It does not move real money.</p>
    <label>From<select value={source} onChange={(e) => setSource(e.target.value)}>{data.accounts.map((a) => <option key={a.id} value={a.id}>{a.name} · {a.maskedNumber} · {money(a.balance)}</option>)}</select></label>
    <label>To<select value={destination} onChange={(e) => setDestination(e.target.value)}>{data.accounts.map((a) => <option key={a.id} value={a.id}>{a.name} · {a.maskedNumber}</option>)}</select></label>
    <label>Amount (INR)<input required min="0.01" step="0.01" inputMode="decimal" placeholder="0.00" value={amount} onChange={(e) => setAmount(e.target.value)} /></label>
    <label>Memo (optional)<input maxLength="80" placeholder="Add a note" value={memo} onChange={(e) => setMemo(e.target.value)} /></label>
    <div className="notice">DEMO ONLY · This transfer remains in server memory and resets when Spring Boot restarts.</div>
    <button className="primary-btn" disabled={busy || !data.accounts.length}>{busy ? "Processing demo…" : "Review and apply demo transfer"}</button>
  </form><section className="panel page-panel"><h2>How the mock core works</h2><p>This demo runs a small in-memory ledger.</p><div className="info-row"><b>Account balances</b><span>Updated in the backend service</span></div><div className="info-row"><b>Transaction history</b><span>Debit and credit entries are added</span></div><div className="info-row"><b>Persistence</b><span>Resets after a server restart</span></div></section></div></>;
}

function CardsPage({ data, onFreeze }) {
  return <><PageHeading eyebrow="PAYMENTS" title="Cards" subtitle="Manage demo card controls and limits." art={cardsArt} /><div className="two-column"><section className="panel page-panel"><h2>My card</h2><p>Masked card details only. No real card number is used.</p>{data.cards.map((card) => <div className="bank-card-preview" key={card.id}><div className="card-top"><span className="chip" /><b>{card.network}</b></div><div className="card-number">{card.maskedNumber}</div><div className="card-top"><span>{card.name}</span><span>{card.expiry}</span></div><div className="card-actions"><span className={card.frozen ? "status paused" : "status"}>{card.frozen ? "Paused" : "Active"}</span><button className="secondary-btn" onClick={() => onFreeze(card)}>{card.frozen ? "Unpause demo card" : "Pause demo card"}</button></div></div>)}</section><section className="panel page-panel"><h2>Card controls</h2><p>Switches are local demo settings.</p><SettingRow label="Online purchases" detail="Allow online card transactions" /><SettingRow label="Contactless payments" detail="Tap to pay at supported terminals" /><SettingRow label="International use" detail="Use card outside your home country" /></section></div></>;
}

function SettingRow({ label, detail }) {
  const [enabled, setEnabled] = useState(label !== "International use");
  return <div className="setting-row"><span><b>{label}</b><small>{detail}</small></span><button className={"switch " + (enabled ? "enabled" : "")} aria-pressed={enabled} onClick={() => setEnabled(!enabled)}><i /></button></div>;
}

function StatementsPage() {
  return <><PageHeading eyebrow="DOCUMENTS" title="Statements" subtitle="Monthly sample statements for the demo account." art={statementsArt} /><section className="panel page-panel"><h2>Available statements</h2><p>Preview actions use sample content only.</p>{["September 2026", "August 2026", "July 2026", "June 2026"].map((month) => <div className="statement-row" key={month}><span className="statement-icon"><Icon name="file" /></span><span><b>{month} statement</b><small>Everyday account · •••• 2048 · PDF preview</small></span><span className="status">Ready</span><button className="link-btn" onClick={() => window.alert("Sample statement preview. No file or bank data is connected.")}>Preview</button></div>)}</section></>;
}

function InsightsPage({ insights }) {
  return <><PageHeading eyebrow="SPENDING & SAVING" title="Insights" subtitle="Illustrative monthly spending categories." art={insightsArt} /><div className="two-column"><Spending insights={insights} /><section className="panel page-panel"><h2>Spending categories</h2><p>Mock monthly totals</p>{insights.categories.map((category) => <div className="category-row" key={category.category}><span className="category-dot" style={{ background: category.color }} /><b>{category.category}</b><strong>{money(category.amount)}</strong></div>)}</section></div></>;
}

function PageHeading({ eyebrow, title, subtitle, art }) {
  return <div className="page-heading"><div><span className="eyebrow">{eyebrow}</span><h1>{title}</h1><p>{subtitle}</p></div>{art && <img className="page-illustration" src={art} alt="" loading="lazy" />}</div>;
}

function CustomizePanel({ layout, setLayout, theme, setTheme, compact, setCompact, close }) {
  const toggle = (id) => setLayout((current) => ({ ...current, visible: { ...current.visible, [id]: !current.visible[id] } }));
  const move = (id, direction) => setLayout((current) => {
    const order = [...current.order], at = order.indexOf(id), to = at + direction;
    if (to < 0 || to >= order.length) return current;
    [order[at], order[to]] = [order[to], order[at]];
    return { ...current, order };
  });
  return <div className="drawer-backdrop" onMouseDown={(event) => event.target === event.currentTarget && close()}><aside className="customizer">
    <div className="drawer-heading"><div><span className="eyebrow">PERSONALIZE</span><h2>Dashboard settings</h2></div><button className="icon-button" onClick={close} aria-label="Close settings"><Icon name="close" /></button></div>
    <p>Reorder or hide dashboard widgets. Your choices are saved in this browser.</p>
    <h3>Widgets</h3><div className="widget-options">{layout.order.map((id, index) => <div className="widget-option" key={id}><label><input type="checkbox" checked={!!layout.visible[id]} onChange={() => toggle(id)} /><span>{WIDGETS.find((w) => w.id === id)?.label}</span></label><span className="move-buttons"><button disabled={index === 0} onClick={() => move(id, -1)} aria-label={"Move " + id + " up"}>↑</button><button disabled={index === layout.order.length - 1} onClick={() => move(id, 1)} aria-label={"Move " + id + " down"}>↓</button></span></div>)}</div>
    <h3>Appearance</h3><div className="appearance-buttons"><button className={theme === "light" ? "chosen" : ""} onClick={() => setTheme("light")}><Icon name="sun" />Light</button><button className={theme === "dark" ? "chosen" : ""} onClick={() => setTheme("dark")}><Icon name="moon" />Dark</button></div>
    <label className="compact-setting"><input type="checkbox" checked={compact} onChange={(e) => setCompact(e.target.checked)} />Use compact spacing</label>
    <button className="secondary-btn reset-btn" onClick={() => { localStorage.removeItem("northstar-layout"); localStorage.removeItem("northstar-theme"); localStorage.removeItem("northstar-compact"); location.reload(); }}>Reset dashboard layout</button>
  </aside></div>;
}

export default function App() {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [apiError, setApiError] = useState("");
  const [token, setToken] = useState("");
  const [authError, setAuthError] = useState("");
  const [authBusy, setAuthBusy] = useState(false);
  const [profile, setProfile] = useState(null);
  const [deposits, setDeposits] = useState([]);
  const [loans, setLoans] = useState([]);
  const [paymentReceipt, setPaymentReceipt] = useState(null);
  const [view, setView] = useState("Overview");
  const [expandedNav, setExpandedNav] = useState({ products: true, payments: true, services: true });
  const [drawer, setDrawer] = useState(false);
  const [busy, setBusy] = useState(false);
  const [notice, setNotice] = useState("");
  const [query, setQuery] = useState("");
  const [theme, setTheme] = useState(() => localStorage.getItem("northstar-theme") || "light");
  const [compact, setCompact] = useState(() => localStorage.getItem("northstar-compact") === "true");
  const [layout, setLayout] = useState(() => {
    try { return JSON.parse(localStorage.getItem("northstar-layout")) || { order: DEFAULT_WIDGETS, visible: Object.fromEntries(DEFAULT_WIDGETS.map((id) => [id, true])) }; }
    catch { return { order: DEFAULT_WIDGETS, visible: Object.fromEntries(DEFAULT_WIDGETS.map((id) => [id, true])) }; }
  });
  const totalBalance = useMemo(() => data?.accounts.reduce((sum, account) => sum + Number(account.balance), 0) || 0, [data]);

  async function apiFetch(path, options = {}, fallback = "The request could not be completed.") {
    let response;
    try {
      response = await fetch(path, options);
    } catch {
      throw new Error("Unable to connect to ByteBharat. Check that the backend is running and try again.");
    }

    let body = null;
    if (response.status !== 204) {
      const responseText = await response.text();
      if (responseText.trim()) {
        try { body = JSON.parse(responseText); }
        catch {
          if (response.ok) throw new Error("The server returned an unexpected response. Please try again.");
        }
      }
    }

    if (!response.ok) {
      const backendMessage = body?.message || body?.detail || body?.title;
      const friendlyByStatus = {
        400: "Some details are missing or invalid. Please review them and try again.",
        401: "Your session has expired or your sign-in details are incorrect. Please sign in again.",
        403: "You are not authorized to perform this action.",
        404: "The requested item could not be found.",
        409: "This request conflicts with the current account state. Refresh and try again.",
        429: "Too many requests. Please wait a moment and try again.",
      };
      const message = response.status >= 500
        ? "The banking service is temporarily unavailable. Please try again shortly."
        : backendMessage || friendlyByStatus[response.status] || fallback;
      throw new Error(message);
    }
    return body;
  }

  async function load(accessToken = token, authenticatedProfile = profile) {
    setLoading(true); setApiError("");
    try {
      const dashboard = await apiFetch("/api/core/dashboard", { headers: { Authorization: "Bearer " + accessToken } }, "Could not load your banking dashboard.");
      setData({ ...dashboard, profile: authenticatedProfile || dashboard.profile });
    } catch (error) {
      if (error.message.includes("session has expired")) { setToken(""); setData(null); }
      setApiError(error.message || "Could not load your banking dashboard. Please try again.");
    } finally { setLoading(false); }
  }

  useEffect(() => {
    let icon = document.querySelector('link[rel="icon"]');
    if (!icon) { icon = document.createElement("link"); icon.rel = "icon"; document.head.appendChild(icon); }
    icon.type = "image/svg+xml"; icon.href = brandIcon;
  }, []);
  useEffect(() => { localStorage.setItem("northstar-layout", JSON.stringify(layout)); }, [layout]);
  useEffect(() => { localStorage.setItem("northstar-theme", theme); }, [theme]);
  useEffect(() => { localStorage.setItem("northstar-compact", String(compact)); }, [compact]);

  async function login(userId, password) {
    setAuthBusy(true); setAuthError("");
    try {
      const body = await apiFetch("/api/auth/login", { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify({ userId, password }) }, "Sign-in failed. Check your details and try again.");
      setToken(body.accessToken);
      const userProfile = await apiFetch("/api/auth/me", { headers: { Authorization: "Bearer " + body.accessToken } }, "Could not load your user profile.");
      setProfile(userProfile);
      await load(body.accessToken, userProfile);
    } catch (error) { setAuthError(error.message || "Unable to sign in."); }
    finally { setAuthBusy(false); }
  }
  function signOut() { setToken(""); setData(null); setProfile(null); setAuthError(""); setView("Overview"); }
  async function apiRequest(path, options = {}) {
    return apiFetch(path, { ...options, headers: { ...(options.headers || {}), Authorization: "Bearer " + token } });
  }
  async function navigate(item) {
    setView(item); setNotice(""); document.getElementById("sidebar")?.classList.remove("open");
    try {
      if (item === "Deposits") setDeposits(await apiRequest("/api/modules/deposits"));
      if (item === "Loans") setLoans(await apiRequest("/api/modules/loans"));
      if (item === "Profile") { const userProfile=await apiRequest("/api/auth/me");setProfile(userProfile);setData(current=>current?{...current,profile:userProfile}:current); }
      if (item === "Accounts") await load();
    } catch (error) { setNotice(error.message); }
  }
  async function requestReset(payload) {
    return apiFetch("/api/auth/password-reset/request", { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify(payload) }, "Could not request a password reset. Please try again.");
  }
  async function completeReset(payload) {
    await apiFetch("/api/auth/password-reset/complete", { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify(payload) }, "Could not reset your password. Please try again.");
  }
  async function openCasa(payload) { setBusy(true); try { await apiRequest("/api/modules/casa", { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify(payload) }); await load(); setNotice("Demo account opened."); } catch(e) { setNotice(e.message); } finally { setBusy(false); } }
  async function openDeposit(payload) { setBusy(true); try { const item=await apiRequest("/api/modules/deposits",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(payload)});setDeposits(current=>[...current,item]);setNotice("Fixed deposit opened in the demo."); } catch(e) { setNotice(e.message); } finally { setBusy(false); } }
  async function applyLoan(payload) { setBusy(true); try { const item=await apiRequest("/api/modules/loans",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(payload)});setLoans(current=>[...current,item]);setNotice("Demo loan application submitted."); } catch(e) { setNotice(e.message); } finally { setBusy(false); } }
  async function makePayment(payload) { setBusy(true);setPaymentReceipt(null);try {const item=await apiRequest("/api/modules/payments",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(payload)});setPaymentReceipt(item);await load();}catch(e){setNotice(e.message);}finally{setBusy(false);}}
  async function saveProfile(payload) { setBusy(true);try{const updated=await apiRequest("/api/auth/profile",{method:"PATCH",headers:{"Content-Type":"application/json"},body:JSON.stringify(payload)});setProfile(updated);setData(current=>current?{...current,profile:updated}:current);setNotice("Profile details saved.");}catch(e){setNotice(e.message);}finally{setBusy(false);}}
  async function transfer(payload) {
    setBusy(true); setNotice("");
    try {
      const body = await apiFetch("/api/core/transfers", { method: "POST", headers: { "Content-Type": "application/json", Authorization: "Bearer " + token }, body: JSON.stringify(payload) }, "Transfer could not be completed. Please try again.");
      setData(body.dashboard); setNotice(body.message); setView("Overview");
    } catch (error) { setNotice(error.message); }
    finally { setBusy(false); }
  }
  async function freezeCard(card) {
    try {
      await apiFetch("/api/core/cards/" + card.id, { method: "PATCH", headers: { "Content-Type": "application/json", Authorization: "Bearer " + token }, body: JSON.stringify({ frozen: !card.frozen }) }, "Could not update the demo card.");
      await load();
    } catch (error) { setNotice(error.message); }
  }

  if (loading && token && !data) return <div className="loading-screen"><div className="spinner" /><p>Connecting to the mock core banking API…</p></div>;
  if (!token || !data) return <Welcome busy={authBusy} error={authError || apiError} onLogin={login} onResetRequest={requestReset} onResetComplete={completeReset} />;
  const page = !data ? null : ({
    Overview: <Overview data={data} layout={layout} query={query} setView={setView} />,
    Accounts: <CasaModule accounts={data.accounts} onOpen={openCasa} busy={busy} />,
    Deposits: <DepositsModule accounts={data.accounts} deposits={deposits} onOpen={openDeposit} busy={busy} />,
    Loans: <LoansModule loans={loans} onApply={applyLoan} busy={busy} />,
    Payments: <PaymentsModule accounts={data.accounts} onPay={makePayment} busy={busy} receipt={paymentReceipt} />,
    Profile: <ProfileModule profile={profile || {}} onSave={saveProfile} busy={busy} />,
    Transfers: <TransfersPage data={data} onTransfer={transfer} busy={busy} />,
    Cards: <CardsPage data={data} onFreeze={freezeCard} />,
    Statements: <StatementsPage />,
    Insights: <InsightsPage insights={data.insights} />
  })[view];
  return <div className={"app-frame theme-" + theme + (compact ? " compact" : "")}>
    <aside className="sidebar" id="sidebar"><Brand /><span className="sidebar-label">PERSONAL BANKING</span><nav className="banking-nav" aria-label="Banking navigation">
      <button className={"nav-item primary-nav " + (view === "Overview" ? "active" : "")} onClick={() => navigate("Overview")}><Icon name="home" />Dashboard</button>
      {NAV_GROUPS.map((group) => <div className="nav-group" key={group.id}><button className="nav-group-toggle" aria-expanded={!!expandedNav[group.id]} onClick={() => setExpandedNav((current) => ({ ...current, [group.id]: !current[group.id] }))}><Icon name={group.icon} /><span>{group.label}</span><i className={expandedNav[group.id] ? "expanded" : ""}>⌄</i></button>{expandedNav[group.id] && <div className="nav-submenu">{group.items.map((item) => <button className={"nav-item " + (view === item ? "active" : "")} key={item} onClick={() => navigate(item)}><span className="nav-dot" />{item}</button>)}</div>}</div>)}
    </nav><div className="sidebar-spacer" /><div className="sidebar-note"><b>Prototype mode</b><span>Transfers update only the in-memory sample ledger.</span></div><div className="profile"><span className="avatar">{data?.profile.initials || "AH"}</span><span><b>{profile?.name || data?.profile.name || "Account holder"}</b><small>Demo user · {profile?.userId || data?.profile.customerId}</small></span></div></aside>
    <main className="main-area"><header className="topbar"><div className="topbar-left"><button className="icon-button mobile-menu" onClick={() => document.getElementById("sidebar").classList.toggle("open")} aria-label="Open navigation"><Icon name="menu" /></button><span className="breadcrumb">Personal banking <b>/</b> {view}</span></div><div className="topbar-actions"><label className="search-box"><Icon name="search" /><input aria-label="Search demo transactions" placeholder="Search activity" value={query} onChange={(e) => setQuery(e.target.value)} /></label><button className="icon-button" onClick={() => setTheme(theme === "light" ? "dark" : "light")} aria-label="Toggle color theme"><Icon name={theme === "light" ? "moon" : "sun"} /></button><button className="icon-button" onClick={() => setNotice("You are all caught up in this demo.")} aria-label="Notifications"><Icon name="bell" /><i className="notification-dot" /></button><button className="customize-button" onClick={() => setDrawer(true)}><Icon name="edit" size={16} />Customize</button><button className="secondary-btn" onClick={signOut}>Sign out</button></div></header>
      <div className="demo-banner">MOCK CORE BANKING · FICTIONAL INR DATA</div>
      {apiError && <div className="inline-error">{apiError}<button onClick={load}>Retry</button></div>}
      {notice && <div className="inline-notice">{notice}<button onClick={() => setNotice("")} aria-label="Dismiss">×</button></div>}
      <div className="page-heading"><div><span className="eyebrow">{view === "Overview" ? "MONDAY · YOUR MONEY AT A GLANCE" : "BYTEBHARAT · DEMO BANKING"}</span><h1>{view === "Overview" ? "Good morning, " + (data?.profile.name.split(" ")[0] || "there") : view}</h1><p>{view === "Overview" ? "Your sample account position and recent activity." : "Explore the " + view.toLowerCase() + " workspace with mock data."}</p></div><span className="as-of">As of {new Date(data?.updatedAt || Date.now()).toLocaleString("en-IN", { dateStyle: "medium", timeStyle: "short" })} IST</span></div>
      {view === "Overview" && <section className="overview-art-banner"><div><span className="eyebrow">BYTEBHARAT · YOUR FINANCIAL OVERVIEW</span><h2>Everyday banking,<br/>at a glance.</h2><p>Accounts, savings and activity in one place.</p></div><img src={overviewArt} alt="Savings, growth and cards illustration" /></section>}
      {view === "Overview" && <div className="overview-summary"><span><b>{money(totalBalance)}</b> total across {data?.accounts.length || 0} sample accounts</span><span className="summary-status"><i /> API connected</span></div>}
      {page}
      <footer className="page-footer">ByteBharat is a fictional prototype. Sample data only · No real banking or payment services are connected.</footer>
    </main>
    {drawer && <CustomizePanel layout={layout} setLayout={setLayout} theme={theme} setTheme={setTheme} compact={compact} setCompact={setCompact} close={() => setDrawer(false)} />}
  </div>;
}

