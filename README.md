# HyBid Calculator (Android, Kotlin)

A simple Android calculator app built in Kotlin demonstrating integration of PubNative HyBid SDK with banner and interstitial ads.

- **AppToken:** `dde3c298b47648459f8ada4a982fa92d`
- **ZoneId:** `1` (used for both banner and interstitial as per assignment instructions)

---
## Features
- Standard calculator operations: addition (+), subtraction (−), multiplication (×), division (÷)

- Banner ad displayed at the bottom of the screen

- Interstitial ad triggered immediately after calculation

---
## Screenshots
Screenshots demonstrating the app are included in the /screenshots folder.

---
## Usage

- Enter two numbers

- Select an operator from the dropdown

- Click Calculate and result will appear

- If loaded, the interstitial ad will display after the calculation

---
## Implementation Notes

- The app uses the HyBid Android SDK for ad integration.

- ZoneId 1 is used because the case study instructions provided ZoneId = 1. Normally, these values come from the HyBid publisher dashboard when creating ad zones.

- Interstitial ads and Banner ads may not display in this demo because ZoneId = 1 is not configured in a real HyBid account.

- In a proper setup with valid ZoneIds, Banner ads and interstitials ads would appear as per assignment requirements.

---
### Attributions
- HyBid Android SDK: https://github.com/pubnative/pubnative-hybid-android-sdk/wiki

