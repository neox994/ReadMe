# ReadMe
Test
RMA –Zadaća 2

Aplikacija predstavlja jednostavni konverter koji se temelji na 4 kategorije, temperatura, brzina, težina i dužina. Klikom na bilo koji imagebutton u glavnom aktivitiju otvara se novi aktiviti u kojemu se odabire mjerna jedinica za unesenu vrijednost u mjerna jedinica u koju želimo konvertirati. Prvi problem prilikom rješavanja zadaća pojavio se kod pronalaženja odabranog elementa u spinneru. Riješenje sam pronasao na sljedećem linku  http://stackoverflow.com/questions/12108893/set-onclicklistener-for-spinner-item.
Nakon klika na gumb Convert koji se pojavljuje u sva 4 aktivitija otvara se novi activiti za prikaz rezultata. Pomoću extra podataka i korištenja stilova result activiti prikazuje ono što je potrebno.
Drugi problem je nastao „kod prebacivanja“ boje pozadine iz aktivitija u result activiti. Riješeno je na način da se u sva četiri aktivitija postavi int varijabla od 1-4 te se u result aktivitiju ovisno o rezultatu postavlja boja pozadine.
U slučaju da je edittext prazan ili ako se upise „.“ izbacit će se toast poruka.
Na dizajnu bi malo trebalo poraditi, i mogući su updat-ovi aplikacije radi povećanja izbora konverzije.
