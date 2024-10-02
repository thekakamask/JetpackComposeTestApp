# CourseKtorAndroidApp
CourseKtorAndroidApp is an basic Android application designed to test Jetpack Compose library for UI design instead of classic XML design.
The app diplay for activities with differents design.

## Main features

- MainActivity : Displays an introduction to Jetpack Compose with a text-based page. The Scaffold composable is used to structure the content, and the Surface composable wraps the entire page with a background color. A clickable interaction is implemented on the whole screen to navigate to the TaskActivity upon tapping.
- TaskActivity : Simulates a task completion screen displaying a success message with an image. The activity displays a "Task Completed" message using Jetpack Compose's Image and Text composables. The layout is centered vertically and horizontally. Clicking on the screen triggers a transition to the QuadrantActivity.
- QuadrantActivity : This activity showcases a quadrant layout, where four different composables (TextComposable, ImageComposable, RowComposable, and ColumnComposable) are displayed in a 2x2 grid-like structure. Each quadrant has a different background color and displays a title and description using Jetpack Compose's Column, Row, and Surface composables. Clicking on the screen navigates the user to the BirthdayActivity.
- BirthdayActivity : Displays a birthday greeting message with an image background. The composable elements consist of a large greeting message and a signature, which are displayed on top of a semi-transparent background image. The screen is fully clickable, and tapping navigates the user back to the MainActivity.
- BusinessCardActivity : Displays a digital business card with a name, professional title and contact information (phone, website and e-mail). Each piece of information is accompanied by a corresponding icon (phone, link and e-mail). The components are arranged in a Column with equal spacing between elements to ensure uniform alignment. The business card is fully clickable and redirects the user to the main screen when tapped.

## Technology

- Jetpack Compose: The app is built entirely using Jetpack Compose for UI design, which provides a declarative approach to building Android interfaces. Instead of XML layouts, composable functions are used to define the UI structure and behavior.
- Material Design 3: The application uses Material Design 3 (also known as Material You) for styling and theming. The MaterialTheme composable provides theming throughout the app, ensuring consistent colors and typography across all activities.