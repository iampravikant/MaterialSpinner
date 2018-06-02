[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)

# Material Spinner
Material Spinner which looks like EditText inside TextInputLayout

# Example

![alt text](https://media.giphy.com/media/2yyGtI4p0AFAUEZ8EL/giphy.gif "Example")

# Usage

**Step 1**: Add `MaterialSpinner` in XML

```xml
<io.pravikant.materialspinner.MaterialSpinner
        android:id="@+id/main_occupation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:ms_hint="Occupation" />
```
**Step 2**: Set items

```kotlin
main_occupation.setItems(resources.getStringArray(R.array.occupations))
```

**Step 3**: Get current selected item

```kotlin
main_occupation.getSelectedItem().toString()
```

<h2>Custom ArrayAdapter</h2>

```kotlin
val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.occupations))
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
main_occupation.setAdapter(adapter)
```

<h2>Attributes</h2>

```xml
<attr name="ms_hint" format="string" />
<attr name="ms_hint_color" format="color" />
<attr name="ms_line_color" format="color" />
<attr name="ms_text_size" format="dimension" />
```

# Download

<h4>Gradle:</h4>

```gradle
repositories {
  mavenCentral()
  google()
}

dependencies {
  implementation 'io.pravikant:materialspinner:1.0.0'
}
```
Note: Don't forget to add `mavenCentral()` under `repositories` in root-level `build.gradle`

<h4>Maven:</h4>

```xml
<dependency>
  <groupId>io.pravikant</groupId>
  <artifactId>materialspinner</artifactId>
  <version>1.0.0</version>
  <type>aar</type>
</dependency>
```

# Author
Pramod Ravikant

[![alt text][1.1]][1]
[![alt text][2.1]][2]
[![alt text][3.1]][3]

[1.1]: http://i.imgur.com/tXSoThF.png (twitter icon with padding)
[2.1]: http://i.imgur.com/P3YfQoD.png (facebook icon with padding)
[3.1]: http://i.imgur.com/0o48UoR.png (github icon with padding)

[1]: http://www.twitter.com/iampravikant
[2]: http://www.facebook.com/iampravikant
[3]: http://www.github.com/iampravikant

# Licence
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details