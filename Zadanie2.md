Ten proces składa się z 8 kroków, które należy wykonać, aby pomyślnie zbudować i opublikować obraz Dockera dla wielu architektur. Poniższe sekcje opisują każdy krok szczegółowo.

Krok 1: Checkout code
Ten krok pozwala na pobranie kodu z repozytorium w celu wykonywania operacji na nim w łancuchu github actions.

Krok 2: Konfiguracja Buildx
Przed przystąpieniem do wieloarchitekturalnej kompilacji musisz skonfigurować Buildx. Buildx to narzędzie umożliwiające wieloarchitekturalne budowanie przy użyciu QEMU. Ten krok zapewnia, że Buildx jest poprawnie zainstalowany i skonfigurowany.

Krok 3: Konfiguracja QEMU dla Dockera
QEMU to narzędzie niezbędne do budowania obrazów dla różnych platform. Ten krok instaluje QEMU, który jest niezbędny do budowy wieloarchitekturalnego obrazu Dockera.

Krok 4: Konfiguracja Gradle
Ten projekt jest budowany za pomocą narzędzia Gradle, dlatego ważne jest skonfigurowanie Gradle jako część procesu. Ten krok zapewnia, że Gradle jest zainstalowany i gotowy do użycia w procesie kompilacji.

Krok 5: Uruchomienie procesu budowania za pomocą Gradle Wrapper
Proces budowania tego projektu jest wykonywany za pomocą Gradle Wrapper. Ten krok uruchamia polecenie budowania przy użyciu Gradle Wrapper, które skompiluje kod i wygeneruje niezbędne artefakty.

Krok 6: Logowanie do DockerHub
Aby opublikować zbudowany obraz, musisz zalogować się do DockerHub. Ten krok wymaga podania niezbędnych danych uwierzytelniających i upewnia się, że jesteś uwierzytelniony, aby przesłać obraz do zdalnego repozytorium.

Krok 7: Budowanie i przesyłanie
Ten krok buduje obraz Dockera przy użyciu artefaktów wygenerowanych w poprzednich krokach. Następnie zbudowany obraz jest przesyłany do zdalnego repozytorium określonego w konfiguracji procesu. Obraz zbudowany w tym kroku ma tag 'multiplatform'.

Podsumowanie
Postępując zgodnie z tymi 8 krokami, możesz pomyślnie zbudować i opublikować wieloarchitekturalny obraz Dockera dla tego projektu.
