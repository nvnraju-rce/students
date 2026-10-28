# ByteBharat Digital Banking Demo

ByteBharat is a local full-stack digital banking learning project with a Java Spring Boot REST API and a React + Vite frontend. Its product modules reflect familiar Indian banking services. All account and customer data is fictional.

## Password reset email configuration

Password reset codes are sent to the registered email address through SMTP and are no longer returned by the API. Configure these environment variables for the backend before starting it:

- `MAIL_HOST` and `MAIL_PORT`
- `MAIL_USERNAME` (defaults to `bytebharat@gmail.com`) and `MAIL_PASSWORD` (set to a Google App Password)
- `MAIL_FROM` (defaults to `MAIL_USERNAME`; use the Gmail address authorized to send)
- `MAIL_SMTP_AUTH` and `MAIL_SMTP_STARTTLS` (optional; default to `true`)

The Gmail defaults use `smtp.gmail.com`, port `587`, and STARTTLS. Before starting the backend in PowerShell, set the Google App Password in the current terminal session: `$env:MAIL_PASSWORD="your-16-character-app-password"`. Create an app password in Google Account settings after enabling 2-Step Verification. The sample text above is a placeholder; it is not a valid password. Do not put a real password in this file or commit mail credentials. When SMTP delivery fails, the reset request returns a service-unavailable error and the code is not accepted for reset.

## What is included

- Overview, CASA accounts, fixed deposits, loan applications, payments, cards, statements, profile maintenance, and spending insights
- Mock core API for dashboard, account, transaction, and card data
- Transfers between sample accounts update the in-memory balances and add debit/credit transaction entries
- Demo card pause/unpause API
- Dashboard personalization: show/hide widgets, move widgets up or down, light/dark theme, and compact spacing
- Personalization is saved in the browser localStorage
- Responsive layouts for laptop and mobile

## Run on Windows

Requirements: Java 21, Eclipse with Maven integration or Maven 3.6.3+, Node.js 20.19+ or 22.12+, and npm.

### 1. Start the Spring Boot API in Eclipse

1. Extract this project ZIP.
2. In Eclipse, choose **File → Import → Maven → Existing Maven Projects**.
3. Browse to the extracted northstar-banking-app/backend folder and finish the import.
4. Open BankingApplication.java, right-click, and choose **Run As → Spring Boot App**.
5. Keep the backend running on http://localhost:8080.

If Maven is installed separately, open PowerShell in the backend folder and run:

    mvn spring-boot:run

### 2. Start the React frontend

Open a second PowerShell window in the frontend folder:

    npm install
    npm run dev

Open the Vite URL printed in the terminal, usually http://localhost:5173.
Vite forwards /api requests to Spring Boot on port 8080.

## API endpoints

- GET /api/health
- GET /api/core/dashboard
- GET /api/core/accounts
- GET /api/core/transactions
- GET /api/core/cards
- POST /api/core/transfers
- PATCH /api/core/cards/{cardId}
- POST /api/auth/password-reset/request and /api/auth/password-reset/complete
- GET/POST /api/modules/casa
- GET/POST /api/modules/deposits and /api/modules/loans
- POST /api/modules/payments
- GET/PATCH /api/auth/me and /api/auth/profile

## Change the mock data

Edit the account, transaction, card, and insight seed values in:

backend/src/main/java/com/northstar/banking/core/MockCoreBankingService.java

Restart Spring Boot to reload the seed data. Demo transfers are held only in server memory and reset when the backend restarts.

The dashboard widgets and appearance can be changed from the **Customize** button in the React UI. To change navigation or add a widget, edit frontend/src/App.jsx; adjust colors, spacing, and responsive behavior in frontend/src/styles.css.

## Important boundary

This project is a local prototype. Login uses demo JWT authentication and H2 user records. Banking products and payment flows use fictional in-memory data; there is no bank integration, payment rail, lending decision, or real customer information. Do not enter real banking credentials or financial data.

A production banking service needs an authorized financial-institution partner, secure identity and access management, a persistent and auditable ledger, fraud controls, encryption, security testing, and legal/compliance review. This prototype is not suitable for handling real funds or customer data.


## Digital banking sign-in (demo)

The UI signs in through `POST /api/auth/login`. Banking API routes under `/api/**` require the returned JWT bearer token; the health route and login are public. Tokens expire after 30 minutes and the demo signing key is generated at startup, so signing in again is required after a backend restart. The token is held in frontend memory and is not persisted in browser storage.

On first backend start, H2 creates the `digital_user` table and seeds a fictional account: user ID `demo`, password `Demo@12345`. Passwords are stored as BCrypt salted one-way hashes and cannot be decrypted. Five consecutive invalid password attempts lock the account for 15 minutes. H2 stores its database file at `C:\Softwares\h2\h2 database\northstar.mv.db`. The datasource uses user `sa` with a blank password for this local demo.

This is a learning prototype, not production banking authentication. Use a managed identity provider and a securely configured persistent signing key for real deployments.


### Banking modules

- **Login / reset password:** JWT login and a 10-minute demo reset code. The demo code is returned to the UI instead of being sent by email/SMS.
- **Accounts:** List sample current and savings accounts and open another demo account.
- **Fixed deposits:** Create deposits with a sample 6.75% annual rate and an estimated maturity amount.
- **Loans:** Submit a demo application and view an indicative EMI using a sample 12% rate; applications remain under review.
- **Payments:** Simulate own-account, internal, domestic and international payments. International payments apply a sample 2% fee. No real network is called.
- **Profile:** Update the demo user's name, mobile number and email.

Product endpoints live under `/api/modules/**` and require the JWT. CASA, deposit, loan, and payment activity remains in memory and resets on backend restart. User credentials/profile remain in H2.


ByteBharat brand icon source: `frontend/images/bytebharat-icon.svg`. Keep reusable visual assets in `frontend/images` and import them from the UI as needed.


### Backend structure and extension points

The reference middleware uses module boundaries, interface contracts, business-policy factories, and local/remote repository adapters. ByteBharat applies those ideas in a lightweight modular Spring application: API controllers call module services; services depend on interfaces; adapters connect module ports to the demo ledger.

Payments use a Strategy registry. Each rail (`OWN`, `INTERNAL`, `DOMESTIC`, `INTERNATIONAL`) implements `PaymentProcessor`; `PaymentService` discovers registered processors through Spring dependency injection. External rails share a template for validation and ledger debit while each rail supplies its fee policy. `AccountLedgerPort` isolates payment processing from the mock core ledger, and `DemoAccountLedgerAdapter` implements that port. Add a rail by implementing `PaymentProcessor` (or the shared external processor template) and registering it as a Spring component; the controller and registry do not need rail-specific branches.

This remains a modular monolith for local development: the modules share one Spring Boot process and one H2-backed user store, while demo product and ledger state remains in memory. It does not claim independent microservice deployment, service discovery, or distributed messaging.
