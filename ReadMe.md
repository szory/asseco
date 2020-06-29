1. Do uruchomienia zadań potrzebne jest załadowanie odpowiedniej struktury dancych. Pliki poniżej zawierają potrzebne dane aby uruchomić program z zadaniami

hr_cre.sql

hr_popul.sql

plik dołączone są do kodu źródłowego

2. Dodatkowo aby połaczyć się z bazą nalezy zmienić url, login i hasło w lini kodu:

dataBaseHandler = new DataBaseHandler("jdbc:oracle:thin:@localhost:1521/xepdb1", "hr", "hr");
