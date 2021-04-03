The considerations of this work are erroneous. I keep it in case it had been referenced and as a curiosity since it is a case in which an excessive adaptation to the training file can cause erroneous resolves when applied to a different test file.

I refer to the most updated version https://github.com/ablanco1950/SUSY_WEIGHTED_V1


# SUSY_WEIGHTED: from the SUSY.csv training  file (https://archive.ics.uci.edu/ml/datasets/SUSY), create a weighted SUSY that, together with a program included in the project, allows obtain success rates higher than 90%. This precision can be increased by following the iterative method of the project.

Resources: Java 8

Functioning:

Once the .jar and .bat files have been downloaded to a directory and assuming that SUSY.csv is in the c: directory, PrepareSusyWeighted.bat is executed which creates a version of SUSY.csv weighted with the name SusyWeighted90PercentHits.txt.

This file serves as input and training to the AssignClassWithSusyWeighted.bat procedure in which it also appears as a test file c:\SUSY.csv, verifying that a rate of 4,512,406 hits is obtained, which out of the 5,000,000 records of SUSY.csv represents a 90.25% accuracy.

In AssignClassWithSusyWeighted.bat you can change C:\SUSY.csv for any test file that has a structure similar to SUSY, obtaining the result with the classes assigned in the FileTextWithClassAsigned.txt file

### Cite this software as:
 ** Alfonso Blanco Garcia ** SUSY_WEIGHTED

More detailed description:

We started trying to evaluate the assignment of classes, using SUSY.csv as a training file, from a statistical procedure: each value of the first 8 significant fields is associated with an index, within the limitations of a table in the program, with two dimensions: one for class 0 and one for class 1, which made it possible to establish for each class the number of occurrences or frequencies of each index and to be able to establish the probability that a certain value of each field corresponded to class 0 or class 1.

With this procedure, using SUSY.csv both as training and test files, a hit rate of 4,225,049 was obtained out of the 5,000,000 SUSY records, which represents a hit rate of 84.5% , which was considered low. Increasing the memory of the program table improved the rate, but since an older low-end notebook was used, it resulted in unacceptable runtimes. Besides, a certain exhaustion was observed, in the sense that more memory increases did not suppose significant improvements in the hit rate. All this, perhaps, because SUSY, despite having 5,000,000 records, does not have a sufficient number of records to be able to make accurate predictions based on probability.

For this reason, the suggestion indicated in the textbook: Artificial Intelligence A Modern Approach, Stuart Rosell, Peter Norvig (Third edition), page 749 and following, referring to the weighted training set was used.

In various iterative steps, adjusting the values ??of the priority of each record and, within each record, the priority of each field, to the maximum number of hits, they were iteratively obtained (the output of each step was the input of the next step), the following results:

PrepareSusyWeighted_0 4,225,049 hits (84.50%)
PrepareSusyWeighted_1 4,268,586 hits (85.37%).
PrepareSusyWeighted_2 4,422,817 hits (88.45%)
PrepareSusyWeighted_3 4,486,726 hits (89.73%)
PrepareSusyWeighted_4 4,512,406 hits (90.25%)

Actually the valued file is that is output from PrepareSusyWeighted_3. With PrepareSusyWeighted_4 all you do is check that from it you can reach the goal of more than 90% correct.

It could continue with more iterations improving the hit rate, since no exhaustion is observed in the last steps.

The weights that are assigned to each record are saved in a new field appending to structute of SUSY.csv, in field 19 counting from zero, keeping the rest of the fields intact.

The project is not parameterizable, the values ??assigned to the priorities of records and fields are adjusted for the dimensions of the memory tables, which allowed to be able to execute the tests by successive approximations of priority of records and fields in a short time.

If we had started from a larger dimension in the memory tables where the frequencies of each field are stored, it would have been possible to reach the objective with fewer iterations, but the time necessary to adjust the priorities of records and fields by successive approximations, I would have unapproachable fact in a low-performance laptop like the one used.

References:
https://archive.ics.uci.edu/ml/datasets/SUSY
Artificial Intelligence A Modern Approach, Stuart Rosell, Peter Norvig (Third edition), page 749 and following referring to weighted training sets
