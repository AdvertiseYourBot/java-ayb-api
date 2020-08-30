# ayb-api

The official Javascript AYB api wrapper. Looking for another language? [C#](https://github.com/AdvertiseYourBot/ayb-api.cs), [Python](https://github.com/AdvertiseYourBot/ayb-api.py), [JavaScript](https://github.com/AdvertiseYourBot/ayb-api). If you would like a specific language added feel free to tell us in our [Discord server](https://discord.gg/bDsTZ29)

The official Java AYB API wrapper. Download the latest release [here](https://github.com/AdvertiseYourBot/ayb-api.java/releases/download/v1.0.0/ayb-api.jar)

## Classes

### Client

###### Methods

- fetchStats()
  - Fetch overall site statistics for ayblisting.com
  - Returns: new Stats(JSONObject obj)

- fetchBot(String id)
  - Fetch a bot from the site using its id
  - Returns: new Bot(JSONObject obj)

- fetchCategory(String id)
  - Fetch a category by id
  - Returns: new Category(JSONObject obj)

###### Properties

- **String base** `The base url for api requests`

---

### Bot

###### Methods

- fetchCategory()
  - Fetch the category of that bot
  - Returns: new Category(JSONObject obj)

###### Properties

- **Boolean success** `If the bot was successfully fetched`

- **String note** `The note, if any, that was sent with the bot`

- **String ownerID** `The user property for the owner of this bot (if a Discord.js v12+ client was passed when initializing the Manager). If no client was passed or no user was found then it will default to the owner's id`

- **String clientID** `The id of this bot`

- **String username** `This bot's username`

- **String avatarURL** `The direct url for this bot's avatar`

- **long votes** `The amount of votes this bot has on ayblisting.com`

- **long categoryID** `The id of this bot's category`

- **Boolean approved** `Whether this bot is approved or not`

- **Boolean certified** `This bot's certification status`

- **Boolean premium** `This bot's premium status`

- **String prefix** `The prefix of this bot`

- **String permissions** `The permissions integer for this bot`

- **String library** `The library used to create this bot`

- **String website** `The url to this bot's website (empty if none)`

- **String githubURL** `The url to this bot's GitHub repository (empty if none)`

- **String supportServerInvite** `The invite url for this bot's support server`

- **String invite** `The invite url for this bot`

- **String url** `The ayblisting.com url for this bot`

- **String briefDesc** `The brief description of the bot`

- **String longDesc** `The long description of the bot`

---

### Category

###### Properties

- **Boolean success** `If the category was successfully fetched`

- **String note** `The note, if any, that was sent with the category`

- **String id** `The id of this category`

- **String name** `The name of this category`

- **String slug** `The slug of this category`

---

### Stats

###### Properties

- **long bots** `The amount of bots currently on the site`

- **long pendingApprovals** `(BETA) THe amount of bots pending approval on the site`

- **long unreadReports** `The number of unread reports on the site`
