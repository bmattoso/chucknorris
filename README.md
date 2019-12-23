# Chuck Norris Facts

The goal of this project is to demonstrate skills on Android development.


## Stack

The main technologies and concepts used are:

- Kotlin
- Clean Architecture + MVVM
- Multi gradle modules
- [RxJava](https://github.com/ReactiveX/RxAndroid)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) (ViewModel + LiveData + Databinding)
- Dependency injection using [Dagger 2.16](https://google.github.io/dagger/)

## Code Style

We're usin ktlint code style, so please add [ktlint](https://ktlint.github.io/) check into `pre-commit` hook
Paste this text in the pre-commit hook file. It'll run  check. This step is useful to get the errors before CI.

```
#!/bin/bash
echo "Running ktlint check"
./gradlew ktlintCheck
RESULT=$?
git stash pop -q
[ $RESULT -ne 0 ] && exit 1 # Fails
exit 0 # Success