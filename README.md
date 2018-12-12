
# react-native-video-thumbnail

## Getting started

`$ npm install git://github.com/mbloody/react-native-video-thumbnail.git --save`

### Mostly automatic installation

`$ react-native link react-native-video-thumbnail`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-video-thumbnail` and add `RNVideoThumbnail.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNVideoThumbnail.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNVideoThumbnailPackage;` to the imports at the top of the file
  - Add `new RNVideoThumbnailPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-video-thumbnail'
  	project(':react-native-video-thumbnail').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-video-thumbnail/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-video-thumbnail')
  	```


## Usage
```javascript
import VideoThumbnail from 'react-native-video-thumbnail';

VideoThumbnail.get(this.path)
  .then((res) => {
    console.log(res);
  })
  .catch((err) => {
    console.log(err);
  });

```
