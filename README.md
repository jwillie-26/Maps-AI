# 🗺️ MapsAI
### 🤖 AI-Powered Travel & Navigation Companion

> "Not all those who wander are lost... but MapsAI makes sure they never are." 😎🧭

---

## 🌍 Overview

MapsAI is a modern Android travel and navigation application built with **Kotlin**, **Firebase**, **Google Maps API**, and **Artificial Intelligence** to help users discover places that match their interests.

Instead of showing the same recommendations to everyone, MapsAI learns user preferences and suggests destinations tailored specifically to them.

Whether you're looking for ☕ cafés, 🌳 parks, 🏛️ museums, 🏖️ attractions, or 🍽️ restaurants, MapsAI helps you find your next adventure.

---

## ✨ Features

### 🔐 Authentication
- Firebase Authentication
- Google Sign-In
- Secure user sessions

### 🎯 Personalized Recommendations
- AI-powered destination suggestions
- Preference-based recommendations
- Future support for learning user behavior

### 🗺️ Interactive Maps
- Google Maps integration
- Place markers
- Real-time navigation
- Route visualization

### ❤️ Favorites
- Save favorite destinations
- Quick access to visited places

### ☁️ Cloud Database
- Firebase Firestore integration
- User preferences storage
- Saved locations synchronization

### 📍 Location Services
- Current user location
- Nearby places discovery
- GPS-powered navigation

---

## 🏗️ System Architecture

```text
┌───────────────────────┐
│     Android App       │
└──────────┬────────────┘
           │
           ▼
┌───────────────────────┐
│ Firebase Authentication│
└──────────┬────────────┘
           │
           ▼
┌───────────────────────┐
│ Firestore Database    │
└──────────┬────────────┘
           │
           ▼
┌───────────────────────┐
│ AI Recommendation     │
│ Engine                │
└──────────┬────────────┘
           │
           ▼
┌───────────────────────┐
│ Google Maps API       │
└───────────────────────┘
```

---

## 📱 Screens

### 🎯 Preferences Screen
Select your interests:

- 🍕 Restaurants
- ☕ Cafés
- 🌳 Parks
- 🏛️ Museums
- 🏨 Hotels

---

### 🏠 Home Screen

Displays:

- Recommended places
- Nearby attractions
- Quick navigation options

---

### 📍 Place Detail Screen

Displays:

- Place name
- Description
- Category
- Save to Favorites

---

### 👤 Profile Screen

Displays:

- User information
- Saved preferences
- Logout functionality

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|----------|
| Kotlin | Android Development |
| Jetpack Compose | UI Development |
| Firebase Auth | User Authentication |
| Firestore | Cloud Database |
| Google Maps API | Mapping & Navigation |
| GitHub | Version Control |
| OpenAI API *(Planned)* | AI Recommendations |

---

## 📂 Project Structure

```text
MapsAI
│
├── data
│   ├── model
│   │   └── Place.kt
│   │
│   └── repository
│       ├── PlacesRepository.kt
│       └── UserRepository.kt
│
├── navigation
│   └── NavGraph.kt
│
├── screens
│   ├── home
│   │   └── HomeScreen.kt
│   │
│   ├── preference
│   │   └── PreferencesScreen.kt
│   │
│   ├── profile
│   │   └── ProfileScreen.kt
│   │
│   ├── detail
│   │   └── PlaceDetailScreen.kt
│   │
│   └── components
│       └── TopBar.kt
│
├── viewmodel
│   └── HomeViewModel.kt
│
└── MainActivity.kt
```

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/jwillie-26/Maps-AI.git
```

---

### 2️⃣ Open in Android Studio

```text
File → Open → Maps-AI
```

---

### 3️⃣ Connect Firebase

1. Open Firebase Console
2. Create Project
3. Add Android App
4. Download `google-services.json`
5. Place file inside:

```text
app/google-services.json
```

---

### 4️⃣ Add Google Maps API Key

Open:

```text
AndroidManifest.xml
```

Add:

```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="YOUR_API_KEY"/>
```

---

### 5️⃣ Sync Gradle

```text
File → Sync Project with Gradle Files
```

---

### 6️⃣ Run Application

```text
Run ▶ app
```

---

## 🔥 Future Enhancements

### 🤖 AI Travel Assistant

- Chatbot travel guide
- Natural language place search
- Smart itinerary generation

---

### 🛣️ Route Optimization

- Fastest route suggestions
- Scenic route recommendations
- Fuel-efficient navigation

---

### 🌦️ Weather Integration

- Weather forecasts
- Weather-aware recommendations

---

### 🧠 Machine Learning

- User behavior analysis
- Personalized recommendations
- Predictive travel suggestions

---

## 🎓 Academic Project

**Institution:** KCA University

**Program:** Diploma in Information Technology

**Project Title:**

> **MapsAI: An AI-Powered Travel and Navigation System**

---

## 🐛 Known Issues

- Occasional GPS delays 📡
- Firebase free-tier limitations ☁️
- Some bugs travel faster than users 🚀😂

---

## 🤝 Contributing

Found a bug? 🐞

Have a cool feature idea? 💡

Want to make MapsAI even more map-nificent? 🗺️😄

Feel free to:

```bash
fork 🍴
clone 📥
code 💻
commit ✅
push 🚀
```

---

## 📜 License

This project is developed for academic and educational purposes.

---

## 🌟 Fun Fact

MapsAI is designed so you spend less time asking:

> ❓ "Where am I?"

and more time saying:

> 😎 "Wow, I didn't know this place existed!"

---

### ⭐ If you like this project, give it a star!

Because every ⭐ helps MapsAI find its way. 🧭✨
