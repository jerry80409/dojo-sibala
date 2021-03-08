## TDD Taka 練習

### 骰子 (4 個)
* 6, 6, 3, 1 -> 4
* 1, 2, 3, 4 -> 0
* 6, 6, 6, 6 -> 一色 (all the same kind)
* 6, 6, 6, 3 -> 0
* 1, 1, 2, 2 -> 4 (取最大)
* Max -> 12 (2, 2, 6, 6)
* Min -> 3 (1, 2, 6, 6)
* 2 人骰子, 結果比大小
* ALL_SAME_THE_KIND : 1 > 4 > 6 > 5 > 3 > 2
* 多一顆骰子, x(1~6)
  input: Amy: 2 2 6 6  Lin: 6 6 3 1
  output:<someone> wins. <winType> <point>

--
* input: "Amy: 2 2 6 6  Lin: 6 6 3 1"
* output: "Amy wins. normal point: 12"

--
* input: "Amy: 2 2 6 6  Lin: 2 6 6 2"
* output: "Tie"

--
* input: "Amy: 1 1 1 1  Lin: 3 3 3 3"
* output: "Lin wins. all the same kind: 3"

--
* input: "Amy: 4 4 3 1  Lin: 4 4 4 1"
* output: "Amy wins. normal points: 5"