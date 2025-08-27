# HyBid Calculator (Android, Kotlin)

A simple calculator app demonstrating **Verve HyBid SDK** integration for a **banner** and an **interstitial**.

- **AppToken:** `dde3c298b47648459f8ada4a982fa92d`
- **ZoneId:** `1` (used for both banner and interstitial in this demo)

## Features
- +, −, ×, ÷ operations
- Banner ad fixed at the bottom
- Interstitial shown after each calculation completes

## Screenshots
Add your screenshots into the `/screenshots` folder. Suggested shots:
- `01_home.png` — Calculator with Banner ad visible
- `02_result_interstitial.png` — Interstitial after a calculation

## How to Run
1. Open the project in **Android Studio Hedgehog/Iguana or newer**.
2. Let Gradle sync (uses AGP 8.5.2 and Kotlin 1.9.24). If prompted, use the recommended Gradle wrapper.
3. Build & run on a device/emulator with internet access.

> If you see missing Gradle wrapper, simply let Android Studio create/update it on first sync.

## Important Notes
- Ensure these permissions are present in `AndroidManifest.xml`: `INTERNET`, `ACCESS_NETWORK_STATE`.
- The project uses dependency `net.pubnative:hybid.sdk:3.6.0` (latest as of June 2025).
- The interstitial is **preloaded** and **shown after a calculation**; after dismiss it **preloads again**.

## Repo Deliverables
- `docs/question-2-discrepancy-playbook.md` — OpenRTB impression discrepancy playbook
- `docs/question-3-client-email.md` — Client email template + info checklist

---
### Attributions
- HyBid Android SDK: https://github.com/pubnative/pubnative-hybid-android-sdk/wiki