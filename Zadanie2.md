### Zadanie 2 - pipeline github actions

## Budowa obrazu dla wielu architektur za pomocą github action:

Ten proces składa się z 8 kroków, które należy wykonać, aby pomyślnie zbudować i opublikować obraz Dockera dla wielu architektur. Poniższe sekcje opisują każdy krok szczegółowo.

## Krok 1: Checkout code

Ten krok pozwala na pobranie kodu z repozytorium na którym będzie pracował łancuch github actions.

## Krok 2: Konfiguracja Buildx

Przed przystąpieniem do wieloarchitekturalnej kompilacji należy skonfigurować buildx, który zostanie użyty do tego celu. 

## Krok 3: Konfiguracja QEMU dla Dockera

QEMU to narzędzie niezbędne do budowania obrazów dla różnych platform. Ten krok instaluje QEMU, który jest niezbędny do budowy wieloarchitekturalnego obrazu Dockera.

## Krok 4: Konfiguracja Gradle

Ten projekt jest budowany za pomocą narzędzia Gradle, dlatego konieczne jest użycie kroku, który zainstaluje go na runnerze, który uruchamia job. 

## Krok 5: Uruchomienie procesu budowania za pomocą Gradle Wrapper

Proces budowania tego projektu jest wykonywany za pomocą Gradle Wrapper. Ten krok uruchamia polecenie budowania przy użyciu Gradle Wrapper, które skompiluje kod i wygeneruje niezbędne artefakty do następnego budowania obrazu. Wrapper użyty w łańcuchu jest w wersji 8.1.1 i jest kompatybilny do Javy wersji 19.

## Krok 6: Logowanie do DockerHub

Logowanie do dockerhub następuje w celu późniejszego opublikowania obrazu na dockerhubie. W tym kroku podawane są login i token do konta na dockerhub.

## Krok 7: Budowanie i przesyłanie

Ten krok buduje obraz Dockera przy użyciu artefaktów wygenerowanych w poprzednich krokach oraz Dockerfile, który został napisany do poprzedniego zadania.  W tym kroku z użyciem qemu jest budowany obraz na architektury linux/arm64/v8,linux/amd64. Następnie zbudowany obraz jest przesyłany do zdalnego repozytorium określonego w konfiguracji procesu. Obraz zbudowany w tym kroku ma tag 'multiplatform'.

W wyniku operacji obraz uruchamia sie prawidłowo:
![Screenshot from 2023-06-14 07-29-50](https://github.com/Misanthrope3011/fullstejk/assets/57143557/5dd6b2a3-a624-475b-a849-f5c5fa2cafb1)

