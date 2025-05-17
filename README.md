# 🧪 Wizard Elixir CLI

**Wizard Elixir CLI** is a **Java Spring Boot command-line application** that helps you discover magical elixirs you can brew using ingredients from the [Wizard World API](https://wizard-world-api.herokuapp.com).  
Built with **Java 21**, **Spring Boot 3**, and reactive **Spring WebFlux WebClient**, it offers a fully interactive terminal experience — no web server required.

---

## ✨ Features

- 📟 Interactive **console-based UI**
- ⚡ Real-time input via `Scanner(System.in)`
- 🌐 Reactive REST integration using **Spring WebClient**
- 🧾 Supports the following commands:
  - `ingredients` — List all available ingredients
  - `phantom elixirs` — List elixirs that require no ingredients
  - `help` — Show available commands and instructions
  - `exit` — Exit the application
  - _any comma-separated list of ingredients_ — Find matching elixirs

---

## 🧱 Built With

- 🧪 **Java 21**
- 🚀 **Spring Boot 3.2+**
- 🔁 **Spring WebFlux (WebClient)**
- ✨ **Lombok**
- 🔧 **Gradle**

---

## ▶️ How to Run

```bash
./gradlew clean build && java -jar build/libs/wizard-cli-0.0.1-SNAPSHOT.jar
```

---

## 🧪 Usage Examples

Once the application starts, you can enter any of the following commands:

| Command                        | Description                                                            |
|-------------------------------|------------------------------------------------------------------------|
| `ingredients`                 | Displays a list of all available ingredients (grouped alphabetically)  |
| `phantom elixirs`            | Lists elixirs that require **no ingredients**                          |
| `elixirs`                    | Lists all elixirs with their required ingredients                      |
| `help`                        | Displays available commands and usage instructions                     |
| `exit`                        | Exits the CLI application                                              |
| `ingredient1, ingredient2...` | Finds elixirs that match the given list of ingredients                |


