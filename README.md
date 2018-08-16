# CucumberSample
Demo cucumber BDD testing for Android, ios, web.

Using [Appium](http://appium.io/) to testing [Android](https://play.google.com/store/apps/details?id=com.wantoto.gomaji2) and [IOS](https://itunes.apple.com/tw/app/gomaji-%E6%9C%80%E5%A4%A7%E5%90%83%E5%96%9D%E7%8E%A9%E6%A8%82%E5%88%B8%E5%B9%B3%E5%8F%B0/id431218690?mt=8) app.

Using selenium ChromeDrive testing [Web](https://hotel.gomaji.com/index.html).

## Run
* Test all feature
```
mvn test
```
* Test destination feaure
```
mvn test -Dcucumber.options="src/test/features/gomaji.feature"
```
* Test destination tags
```
mvn test -Dcucumber.options="--tags @android_reinstall"
```
* Only test Web tag.
```
mvn test -Dcucumber.options="--tags @web"
```


## Screenshot
![2018-08-07 3 05 00](https://user-images.githubusercontent.com/3991213/43759956-5e8aa3b4-9a53-11e8-8882-82738a6aa0fa.png)
