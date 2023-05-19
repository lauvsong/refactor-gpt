# refactor-gpt

![Build](https://github.com/lauvsong/refactor-gpt/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

<!-- Plugin description -->
Super simple plugin to refactor selected code using ChatGPT.
1. Select the code
2. Press alt + R
3. After few seconds, the refactored code will be shown.
4. Edit refactored code if you want.
5. Enjoy!
<!-- Plugin description end -->

## Overview
RefactorGPT is a super simple yet powerful JetBrains IDE plugin designed to **streamline your code refactoring process**.
Built on the technology of OpenAI's ChatGPT, this plugin assists developers by providing refined, improved code directly within their IDE of choice.

## Benefits
1. **Seamless Integration**: Fits smoothly within your JetBrains IDE environment.
2. **Easy Access**: Just select your code and press alt + R.
3. **Interactive Refactoring**: Gives you refactored code suggestions in seconds which you can further edit before implementing.
4. **Boost Productivity**: Minimize time spent on manual refactoring and concentrate on your main project.

## Configuration
Before you start using RefactorGPT, you need to provide your OpenAI ChatGPT API Key. This is essential for the plugin to access the language model's capabilities and generate refactoring suggestions.

Also, you can set the API timeout according to your preference. This option provides flexibility in terms of how long you're willing to wait for the API to generate refactoring suggestions.

To configure these settings:

Navigate to <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>RefactorGPT</kbd>.
Enter your OpenAI ChatGPT API Key in the designated field.
Set your preferred API timeout duration.
Click <kbd>Apply</kbd> and then <kbd>OK</kbd> to save the changes.

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "RefactorGPT"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/lauvsong/refactor-gpt/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
RefactorGPT is proudly based on the [IntelliJ Platform Plugin Template][template]. We continually strive to enhance our plugin to provide a seamless and enriching user experience. For any suggestions or queries, please reach out to us. Happy refactoring!

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
