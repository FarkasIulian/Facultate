#SECONDS=0

loguri(){
        ls /var/log | grep \\.log
	grep $1 /var/log/$2
}

while [ 1 ]
do 
echo "1.Iesire."
echo "2.Afisare date sistem."
echo "3.Craciun."
echo "4.Afisare shell."
echo "5.Afisare utilizatori."
echo "6.Afisare ultimele linii."
echo "7.Afisare tip procesor/cache."
echo "8.LS director proc."
echo "9.Fisiere log."
echo "Dati optiunea:" 
read opt
case $opt in
	1)exit;;
	2)echo "ID-ul procesului initializat la acest script este: $$"
	  echo "Tipul sistemului de operare este: $OSTYPE"
	  echo "Timpul trecut de la inceperea scriptului in secunde: $SECONDS seconds"
	  echo "Calea curenta:"
	  pwd
	  echo -e "\n";;
	3)echo "Numarul saptamanii craciunului si a zilei:"
	  date -d "2022-12-25" "+%W %u"
	  echo -e "\n";;
	4)head -n 3 /etc/shells | grep /bin
	  echo -e "\n";;
	5)awk -F : '{print $1,$3,$5,$6}' /etc/passwd
	  echo -e "\n";;
	6)echo "Afisare ultimele 9 linii"
	  tail /etc/protocols -n 9
	  var=$(wc -l < /etc/protocols)
	  echo -e "\n"
	  echo "Tail de la linia 9 in jos"
	  tail /etc/protocols -n $(($var-9))
	  echo -e "\n";;
	7)grep model /proc/cpuinfo | tail -n 1
	  grep cache /proc/cpuinfo | head -n 1;;
	8)ls --ignore='[0-9]*' /proc;;
	9)ls /var/log
	echo "Introduceti log-ul pe care doriti sa-l verificati: "
	read file
	echo "Introduceti cuvantul cautat in log: "
	read cuvant
	loguri $cuvant $file;;
	*)echo "Optiune inexistenta";;
esac
done 
