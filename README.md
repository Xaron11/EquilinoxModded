# EquilinoxModded
EquilinoxModded is a modding framework for [Equilinox](https://www.equilinox.com) game created by ThinMatrix and written in Java.

EquilinoxModded is being actively updated and you can check out what I am working on my [EquilinoxModded Project](https://github.com/Xaron11/EquilinoxModded/projects/1) page.

**Note: Currently only Windows version of the game is supported.**

## Getting Started
To start using EquilinoxModded framework follow these few simple steps:

1. Download current release from [Releases](https://github.com/Xaron11/EquilinoxModded/releases) section.
2. Move downloaded JAR file to your Equilinox game's directory, next to _EquilinoxWindows.jar_.
3. * Simply run ``EquilinoxModded.jar`` and wait. This shouldn't take more than a minute.
   * or run ``java -jar EquilinoxModded.jar`` command in Command Prompt (CMD) to see detailed info about the process.
4. When it's done you should see ``EquilinoxWindows - Modded.jar`` file and ``mods`` folder created in your directory.
5. To play Equilinox game with mods run ``EquilinoxWindows - Modded.jar`` (Of course, put your favorite mods in the `mods` folder before or make your own mod with the help from [EqulinoxModded Wiki](https://github.com/Xaron11/EquilinoxModded/wiki) and [ExampleMod Repository](https://github.com/Xaron11/EquilinoxModded-ExampleMod)).
6. **Enjoy your modded Equilinox experience!**

## How To Make Your Own Mod?
If you have an amazing idea on what to add to Equilinox game feel free to make your own mod with my framework. Start by going to the [Wiki](https://github.com/Xaron11/EquilinoxModded/wiki) page and reading _Getting Started_ section. You can then play it by yourself, send it to your friends or post online (If so I only want you to credit this modding framework, so more people could use it).

## How To Contribute?
I really appreciate it if you want to help me with this project. Here's what you can do:
* [Create an issue](https://github.com/Xaron11/EquilinoxModded/issues) if you found something that need to be fixed or you have an idea for something I can add.
* [Create a pull request](https://github.com/Xaron11/EquilinoxModded/pulls) if you want to directly contribute in this project.

## Working With Source Code
To work with this repository you need to:
1. Clone this repository by executing: `git clone https://github.com/Xaron11/EquilinoxModded.git` or download a [ZIP file](https://github.com/Xaron11/EquilinoxModded/archive/master.zip) and unpack it.
2. Open the project with you IDE.
3. In `build.gradle` file, edit line with: `destinationDirectory` to specify EquilinoxModded build export directory (I recommend to use Equilinox game's directory).
4. Copy `EquilinoxWindows.jar` from your Equilinox game's directory to the `lib` folder.
5. Build source code and export by running `gradlew jar`.
