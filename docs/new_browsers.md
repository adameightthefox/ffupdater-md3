# New browsers and how an app is added

## How apps are added (the author's pattern)

Every app is one Kotlin `object` in `app/impl/` that extends `AppBase` and is wired up in five places:

1. `app/impl/<Name>.kt`: package name, signature hash, ABIs, min API, project page, `displayCategory`
   and `fetchLatestUpdate()`, which asks a consumer (`GithubConsumer`, `GitLabConsumer`, ...) for the newest
   release and returns a `LatestVersion` (download URL, version, date).
2. `app/App.kt`: a new enum value and a branch in `findImpl()`. New values are appended at the end,
   because the ordinal is used for the installation chronology.
3. `res/values/strings.xml`: `<name>__title`, `<name>__description`, optional `<name>__warning`.
4. `AndroidManifest.xml`: the package name in `<queries>`, otherwise Android 11+ hides the installed app.
5. `res/drawable/ic_logo_<name>.*`: the logo.

The category (`DisplayCategory`) decides under which heading the app appears in "Add app":
`FROM_MOZILLA`, `BASED_ON_FIREFOX`, `GOOD_PRIVACY_BROWSER`, `GOOD_SECURITY_BROWSER`,
`BETTER_THAN_GOOGLE_CHROME`, `OTHER`, `EOL`. An app can have several categories and then appears under each one.
Old browsers are not deleted. They are moved to `EOL`/`docs/deprecated_browsers.md`.

## Added browsers

| Browser | Engine | Source | Package | Categories |
|---|---|---|---|---|
| Waterfox | Gecko (Fenix/GeckoView, ESR) | https://github.com/BrowserWorks/waterfox-android | `net.waterfox.android.release` | Based on Firefox, Good privacy |
| Titanium (ex-Helium) | Chromium + Vanadium patches | https://github.com/jqssun/android-titanium-browser | `io.github.jqssun.helium` | Better than Chrome, Good privacy, Good security |
| Midori | GeckoView | https://github.com/goastian/midori-android | `org.midorinext.android` | Based on Firefox |

* **Waterfox**: Firefox-based, rebuilt from source with its own Android Components, no telemetry, a stable ESR
  engine and the full Mozilla add-on store. The GitHub APK is signed with a different key than the Play build.
* **Titanium**: Chromium with desktop extensions (uBlock Origin etc.), built on GrapheneOS Vanadium.
  Formerly "Helium Browser for Android". It is an unofficial project by jqssun and is *not* the desktop Helium
  by imput. The package name still contains `helium` for update compatibility.
* **Midori**: lightweight GeckoView browser with tabs, private mode and extension support.

## Open points before a release

* `signatureHash` in `Waterfox`, `Titanium`, `Midori` is a placeholder (all zeros).
  Get the real value: `apksigner verify --print-certs <apk>` -> SHA-256 of the certificate.
* APK names and ABIs of the three projects were not verifiable (GitHub asset lists are not readable without a
  login/API). `AbiAssetMatcher` picks the APK by common ABI spellings. Check the first real run.
* Logos are placeholders (`ic_logo_waterfox/titanium/midori.xml`). Replace with the official logos.
