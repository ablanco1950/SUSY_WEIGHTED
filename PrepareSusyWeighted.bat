java -jar PrepareSusyWeighted_0.jar c:\SUSY.csv c:\SUSY.csv
java -jar PrepareSusyWeighted_1.jar SusyWeighted.txt SusyWeighted.txt
erase SusyWeighted.txt
rename SusyWeighted_1.txt SusyWeighted.txt
java -jar PrepareSusyWeighted_2.jar SusyWeighted.txt SusyWeighted.txt
erase SusyWeighted.txt
rename SusyWeighted_1.txt SusyWeighted.txt
java -jar PrepareSusyWeighted_3.jar SusyWeighted.txt SusyWeighted.txt
erase SusyWeighted.txt
rename SusyWeighted_1.txt SusyWeighted.txt
java -jar PrepareSusyWeighted_4.jar SusyWeighted.txt SusyWeighted.txt
erase SusyWeighted_1.txt
erase SusyWeighted90PercentHits.txt
rename SusyWeighted.txt SusyWeighted90PercentHits.txt

