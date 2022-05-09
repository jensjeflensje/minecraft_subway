![](https://files.jederu.nl/2022-05-08_20.32.46.png)
# Subways
A Spigot plugin that adds subways/trams to Minecraft.

## Info
I wanted to make a subway first, but it turned out to look more like a tram, whoops.
This plugin was made and tested on Minecraft version 1.12.2. It'll probably work on other versions, but I haven't tested it on them.
It was made with the default Minecraft texture pack in mind. Some texture packs will make it look weird.

**Note:** The plugin may produce lag for server and client. So please be aware of that.

### Commands
| Command                                        | Description                                                                                                                                                        |
|------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `/subway`                                      | Shows the subway help menu.                                                                                                                                        |
| `/subway addpoint <track> [true]`              | Adds a point to the track (and initializes the track). The `true` argument is not necessary, it indicates if this is a stop (so it'll wait 5 seconds on this point |
| `/subway delpoint <track> <point_id>`          | Removes a point with a specific ID from the track.                                                                                                                 |
| `/subway deltrack <track>`                     | Removes a track.                                                                                                                                                   |
| `/subway settype <track> <subway_type>`        | Set a track to use a specific subway type. Currently only `default` works.                                                                                         |
| `/subway setspeed <track> <speed>`             | Set the speed of the subway on the track. Should be beteween 0.1 and 0.5 for expected results.                                                                     |
| `/subway setautospawn <track> <true or false>` | Determines whether a subway should be spawned on start/reload of the server.                                                                                       |                                                                                                                                                                    |
| `/subway spawn <track>`                        | Manually spawn a subway on a track.                                                                                                                                |
| `/subway remove <track>`                       | Remove all subways from a track.                                                                                                                                   |

### Setup guide
- Build a track for your subway to ride on.
- Add points to the track with `/subway addpoint <track> [true]` (true determines if the subway should wait 5 seconds at this point).
- (not strictly necessary) Set the subway type with `/subway settype <track> <subway_type>`.
- (not strictly necessary) Set the speed of the subway with `/subway setspeed <track> <speed>`.
- (not strictly necessary) Set whether a subway should be spawned on start/reload of the server with `/subway setautospawn <track> <true or false>`.
- Restart the server (if autospawn is on) or manually spawn a subway with `/subway spawn <track>`.

### Permissions
There's only one permission to configure subways: `subway.admin`. There will probably be other permissions later on.

### Contributing
Feel free to contribute! It's very easy to add new trams/subways/vehicles to the system, so please do, and create a PR of course :).

### Demo
Watch the demo [here](https://www.youtube.com/watch?v=blE-pjqZLmo).