#kruskals #hackerrank #williamfiset #algorithm #graphtheory #mst #java #programming

I made this program to help myself, and other learners, better understand this algorithm and the union-find data structure. William Fiset's videos and source code really helped me to get to grips with this. It's largely based on his implementation, with a few changes (I removed a duplicate check for cycles, used more descriptive variable names, and did the find recursively (just because:))). I included extensive comments for noobs like me, a test/driver class, and a "UI debug helper" class that provides a visual display of the progress.

The unusual data input format is dictated by the HackerRank challenge - if you comment out all the calls to "uiDebugHelper", the "Result" class will pass the challenge. Links to the challenge, William Fiset's material, and my program's repo will be below in the first comment. I hope this helps someone!

The challenge: https://www.hackerrank.com/challenges/kruskalmstrsub/problem?isFullScreen=true

William Fiset Youtube: https://www.youtube.com/watch?v=KbFlZYCpONw

William Fiset's source code: https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/KruskalsEdgeList.java
