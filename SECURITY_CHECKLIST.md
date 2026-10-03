# NEXA Security Checklist

## Already implemented in this starter
- Passwords are never stored in plaintext.
- Password hashing uses Node `scrypt` with per-password random salt.
- Authentication uses an HttpOnly, SameSite cookie.
- Basic API rate limiting.
- Helmet security headers.
- Server-side input validation.
- Parameterized SQL queries.
- Server-side authorization on protected endpoints.
- Audit-log foundation.
- Secrets are kept in environment variables.

## Before public launch
- Enable HTTPS and `COOKIE_SECURE=true`.
- Add email verification.
- Add password reset with short-lived, single-use tokens.
- Add MFA/passkeys.
- Add stronger abuse/bot controls.
- Add CSRF protection if authentication architecture changes.
- Add upload allowlists, MIME sniffing, malware scanning, size limits and transcoding.
- Put user media behind controlled/private storage and signed URLs where appropriate.
- Add moderation and anti-scam systems.
- Add database backups and restore drills.
- Add monitoring, alerting and intrusion detection.
- Run dependency, SAST/DAST and penetration testing.
- Have an independent security professional review the production system.
