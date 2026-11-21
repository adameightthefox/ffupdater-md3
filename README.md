<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
[![All Contributors](https://img.shields.io/badge/all_contributors-20-orange.svg?style=flat-square)](#contributors-)
<!-- ALL-CONTRIBUTORS-BADGE:END -->

# Firefox-Updater (fork: ffupdater-md3)

> **This is a fork of [Tobi823/ffupdater](https://github.com/Tobi823/ffupdater).**
> The original project has not been updated for a long time, so I (@adameightthefox) keep this fork alive with
> new browsers and a modernised look. **I do not claim authorship of the app.** All credit for FFUpdater goes to
> Tobias Hellmann ([Tobi823](https://github.com/Tobi823)), Boris Kraut and all
> [contributors](#contributors-) of the original project. This fork only adds the changes listed below and
> is published under the same license (GPL-3.0-or-later).
>
> Changes in this fork:
>
> - 🆕 New browsers: **Waterfox**, **Titanium** (formerly Helium Browser for Android) and **Midori**
> - 🆕 Material 3 (Material You) design with dynamic colors
> - 🆕 Optional pure black **AMOLED** theme (Settings -> below the theme selection)
> - 🆕 Russian and German descriptions for the new browsers
>
> Note: the package name is still `de.marmaro.krt.ffupdater`, but the app is signed with a different key than the
> original. You have to uninstall the original FFUpdater before installing this fork. The F-Droid / Google Play
> versions of the original are **not** this fork. APK files are published in the
> [releases of this repository](https://github.com/adameightthefox/ffupdater-md3/releases).

Installs and updates the following browsers (🆕 = added in this fork, see [new browsers](docs/new_browsers.md)):

Software from Mozilla or based on Firefox:

- [Fennec F-Droid](https://f-droid.org/packages/org.mozilla.fennec_fdroid/)
- [Firefox Browser](https://play.google.com/store/apps/details?id=org.mozilla.firefox),
  [Firefox for Android Beta](https://play.google.com/store/apps/details?id=org.mozilla.firefox_beta),
  [Firefox Nightly](https://play.google.com/store/apps/details?id=org.mozilla.firefox)
  ([GitHub Repository](https://github.com/mozilla-mobile/firefox-android))
- [Firefox Focus](https://play.google.com/store/apps/details?id=org.mozilla.focus), Firefox Focus Beta,
  [Firefox Klar](https://play.google.com/store/apps/details?id=org.mozilla.klar)
  ([GitHub Repository](https://github.com/mozilla-mobile/firefox-android))
- [Iceraven](https://github.com/fork-maintainers/iceraven-browser)
- [Waterfox](https://github.com/BrowserWorks/waterfox-android) 🆕 **new**
- [Midori](https://github.com/goastian/midori-android) 🆕 **new**
- [Tor Browser](https://www.torproject.org/download),
  [Tor Browser Alpha](https://www.torproject.org/download/alpha/)
- [Thunderbird for Android](https://play.google.com/store/apps/details?id=net.thunderbird.android),
  [Thunderbird for Android Beta](https://play.google.com/store/apps/details?id=net.thunderbird.android.beta)
  ([GitHub Repository](https://github.com/thunderbird/thunderbird-android/))

Browser which are better than Google Chrome:

- [Brave Private Browser](https://play.google.com/store/apps/details?id=com.brave.browser&hl=en_US),
  [Brave Browser (Beta)](https://play.google.com/store/apps/details?id=com.brave.browser_beta&gl=US),
  [Brave Browser (Nightly)](https://play.google.com/store/apps/details?id=com.brave.browser_nightly&gl=US)
  ([GitHub Repository](https://github.com/brave/brave-browser))
- [Cromite](https://github.com/uazo/cromite)
- [Chromium](https://www.chromium.org/chromium-projects/)
- [DuckDuckGo Browser](https://github.com/duckduckgo/Android)
- [Privacy Browser](https://f-droid.org/en/packages/com.stoutner.privacybrowser.standard/)
- [Vivaldi](https://vivaldi.com/download/) ([Incomplete Source Code](https://vivaldi.com/source/))
- [Thorium](https://github.com/Alex313031/Thorium-Android)
- [Titanium (formerly Helium Browser for Android)](https://github.com/jqssun/android-titanium-browser) 🆕 **new**

Other applications:

- [FairEmail](https://github.com/M66B/FairEmail)
- [K-9 Mail](https://k9mail.app)
- [Orbot](https://github.com/guardianproject/orbot)

FFUpdater checks for updates in the background and downloads them as well. Apps can be updated without user
interaction with:

- Android 12 or higher
- rooted smartphone
- [Shizuku](https://shizuku.rikka.app/) / [Sui](https://github.com/RikkaApps/Sui) with Android 6 or higher

## Thanks

## New in this fork

| Browser | Engine | Category | Source |
|---|---|---|---|
| 🆕 Waterfox | Gecko (Firefox ESR based) | Based on Firefox, good privacy | [BrowserWorks/waterfox-android](https://github.com/BrowserWorks/waterfox-android) |
| 🆕 Titanium (ex-Helium) | Chromium + Vanadium patches | Better than Chrome, good privacy and security | [jqssun/android-titanium-browser](https://github.com/jqssun/android-titanium-browser) |
| 🆕 Midori | GeckoView | Based on Firefox | [goastian/midori-android](https://github.com/goastian/midori-android) |

Titanium is an unofficial community project and is not the desktop Helium browser. Details and open points:
[docs/new_browsers.md](docs/new_browsers.md).

## FAQ

- By clicking on the "i"-Icon, you can see the time of the last successful background update check.
- Please reopen FFUpdater after moving it to the internal/external storage.
- When the 'power save mode' is activated, FFUpdater's behavior changes. If the mode is on for less than 24
  hours, FFUpdater will not perform any background update checks. However, if it remains on for longer,
  FFUpdater will check for updates in the background, but it will not download them in the background.

## How to contribute

You can improve the translation on [Weblate](https://hosted.weblate.org/projects/ffupdater) (this is the Weblate project of the original FFUpdater; translations of this fork's new strings are done via pull requests here). Current progress:
[<img align="right" src="https://hosted.weblate.org/widgets/ffupdater/-/287x66-white.png" alt="Get involved in translating FFUpdater" />](https://hosted.weblate.org/engage/ffupdater/?utm_source=widget)

[![Translation status](https://hosted.weblate.org/widgets/ffupdater/-/multi-auto.svg)](https://hosted.weblate.org/engage/ffupdater/?utm_source=widget)

Your translation contribution will be acknowledged in every release changelog.

For advanced users: [How to contribute](HOW_TO_CONTRIBUTE.md)

## Source Code Contributors

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/StoyanDimitrov"><img src="https://avatars.githubusercontent.com/u/10962709?v=4?s=100" width="100px;" alt="StoyanDimitrov"/><br /><sub><b>StoyanDimitrov</b></sub></a><br /><a href="#translation-StoyanDimitrov" title="Translation">🌍</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/SkewedZeppelin"><img src="https://avatars.githubusercontent.com/u/8296104?v=4?s=100" width="100px;" alt="SkewedZeppelin"/><br /><sub><b>SkewedZeppelin</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/commits?author=SkewedZeppelin" title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="http://www.linestarve.com/"><img src="https://avatars.githubusercontent.com/u/2261204?v=4?s=100" width="100px;" alt="Wolfgang Faust"/><br /><sub><b>Wolfgang Faust</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/commits?author=wolfgang42" title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/gnuhead-chieb"><img src="https://avatars.githubusercontent.com/u/41156994?v=4?s=100" width="100px;" alt="gnuhead-chieb"/><br /><sub><b>gnuhead-chieb</b></sub></a><br /><a href="#translation-gnuhead-chieb" title="Translation">🌍</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/Nickoriginal"><img src="https://avatars.githubusercontent.com/u/85299944?v=4?s=100" width="100px;" alt="Nickoriginal"/><br /><sub><b>Nickoriginal</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/commits?author=Nickoriginal" title="Documentation">📖</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/motuzj"><img src="https://avatars.githubusercontent.com/u/30744041?v=4?s=100" width="100px;" alt="Juraj Motuz"/><br /><sub><b>Juraj Motuz</b></sub></a><br /><a href="#translation-motuzj" title="Translation">🌍</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/metezd"><img src="https://avatars.githubusercontent.com/u/37701679?v=4?s=100" width="100px;" alt="metezd"/><br /><sub><b>metezd</b></sub></a><br /><a href="#translation-metezd" title="Translation">🌍</a></td>
    </tr>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/gdonisi"><img src="https://avatars.githubusercontent.com/u/82442402?v=4?s=100" width="100px;" alt="Giovanni Donisi"/><br /><sub><b>Giovanni Donisi</b></sub></a><br /><a href="#translation-gdonisi" title="Translation">🌍</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/jerryjean"><img src="https://avatars.githubusercontent.com/u/17931090?v=4?s=100" width="100px;" alt="Jerry Jean-Baptiste"/><br /><sub><b>Jerry Jean-Baptiste</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/commits?author=jerryjean" title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/rusty-snake"><img src="https://avatars.githubusercontent.com/u/41237666?v=4?s=100" width="100px;" alt="rusty-snake"/><br /><sub><b>rusty-snake</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/commits?author=rusty-snake" title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/Usland123"><img src="https://avatars.githubusercontent.com/u/72984028?v=4?s=100" width="100px;" alt="Usland123"/><br /><sub><b>Usland123</b></sub></a><br /><a href="#translation-Usland123" title="Translation">🌍</a> <a href="https://github.com/Tobi823/ffupdater/commits?author=Usland123" title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/e406hsy"><img src="https://avatars.githubusercontent.com/u/47596290?v=4?s=100" width="100px;" alt="홍순용"/><br /><sub><b>홍순용</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/commits?author=e406hsy" title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/ubergeek77"><img src="https://avatars.githubusercontent.com/u/3455585?v=4?s=100" width="100px;" alt="ubergeek77"/><br /><sub><b>ubergeek77</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/commits?author=ubergeek77" title="Documentation">📖</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/guy-teube"><img src="https://avatars.githubusercontent.com/u/18379228?v=4?s=100" width="100px;" alt="guy-teube"/><br /><sub><b>guy-teube</b></sub></a><br /><a href="#translation-guy-teube" title="Translation">🌍</a></td>
    </tr>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/nortio"><img src="https://avatars.githubusercontent.com/u/22685799?v=4?s=100" width="100px;" alt="nortio"/><br /><sub><b>nortio</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/commits?author=nortio" title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/chenxiaolong"><img src="https://avatars.githubusercontent.com/u/646253?v=4?s=100" width="100px;" alt="Andrew Gunnerson"/><br /><sub><b>Andrew Gunnerson</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/commits?author=chenxiaolong" title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/TeeTeeHaa"><img src="https://avatars.githubusercontent.com/u/739754?v=4?s=100" width="100px;" alt="TeeTeeHaa"/><br /><sub><b>TeeTeeHaa</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/issues?q=author%3ATeeTeeHaa" title="Bug reports">🐛</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/kewisch"><img src="https://avatars.githubusercontent.com/u/607198?v=4?s=100" width="100px;" alt="Philipp Kewisch"/><br /><sub><b>Philipp Kewisch</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/commits?author=kewisch" title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/kazushi3"><img src="https://avatars.githubusercontent.com/u/57816457?v=4?s=100" width="100px;" alt="kazushi3"/><br /><sub><b>kazushi3</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/commits?author=kazushi3" title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://lisa-yuki.de"><img src="https://avatars.githubusercontent.com/u/86305405?v=4?s=100" width="100px;" alt="Lisa"/><br /><sub><b>Lisa</b></sub></a><br /><a href="https://github.com/Tobi823/ffupdater/commits?author=BloxerExists" title="Code">💻</a></td>
    </tr>
  </tbody>
  <tfoot>
    <tr>
      <td align="center" size="13px" colspan="7">
        <img src="https://raw.githubusercontent.com/all-contributors/all-contributors-cli/1b8533af435da9854653492b1327a23a4dbd0a10/assets/logo-small.svg">
          <a href="https://all-contributors.js.org/docs/en/bot/usage">Add your contributions</a>
        </img>
      </td>
    </tr>
  </tfoot>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

## Additional documentation

[Security measures](docs/security_measures.md)

[Download sources](docs/download_sources.md)

[F-Droid repository / APK files / other distribution channels](docs/other_distribution_channels.md)

[3rd-party libraries](docs/3rd_party_libraries.md)

[Deprecated browsers](docs/deprecated_browsers.md)

[Maintainer](docs/maintainer.md)

[My goals](GOALS.md)

## Git repositories

- This fork: https://github.com/adameightthefox/ffupdater-md3
- Original project (by Tobi823, no longer updated regularly): https://github.com/Tobi823/ffupdater
  - Mirror on notabug.org: https://notabug.org/Tobiwan/ffupdater
  - Mirror on Gitlab: https://gitlab.com/Tobiwan/ffupdater_gitlab

## License

````
FFUpdater -- Updater for privacy friendly browser
Copyright (C) 2019-2023 Tobias Hellmann https://github.com/Tobi823
Copyright (C) 2015-2019 Boris Kraut <krt@nurfuerspam.de>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
````