(ns AdventOfCode.AoC-Day2)

(def programAlarmState [1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,13,1,19,1,19,10,23,1,23,13,27,1,6,27,31,1,9,31,35,2,10,35,39,1,39,6,43,1,6,43,47,2,13,47,51,1,51,6,55,2,6,55,59,2,59,6,63,2,63,13,67,1,5,67,71,2,9,71,75,1,5,75,79,1,5,79,83,1,83,6,87,1,87,6,91,1,91,5,95,2,10,95,99,1,5,99,103,1,10,103,107,1,107,9,111,2,111,10,115,1,115,9,119,1,13,119,123,1,123,9,127,1,5,127,131,2,13,131,135,1,9,135,139,1,2,139,143,1,13,143,0,99,2,0,14,0])

(defn opcode-response
  "Determines the opcode from the first character "
  [opcode]
  (condp = opcode
    99 "exit"
    1 +
    2 *
    "error"
  )
)

(defn perform-operation
  ""
  [programState]
  (loop
    [state programState
     intcodeIndex 0
     opcode (opcode-response (get state 0))
     position1 (get state 1)
     position2 (get state 2)
     position3 (get state 3)]
    (def nextIntcodeIndex (+ 4 intcodeIndex))
    (condp = opcode
      "exit" state
      "error" "Program encountered an error"
      (recur
        (assoc state position3 (opcode (get state position1) (get state position2)))
        nextIntcodeIndex
        (opcode-response (get state nextIntcodeIndex))
        (get state (+ 1 nextIntcodeIndex))
        (get state (+ 2 nextIntcodeIndex))
        (get state (+ 3 nextIntcodeIndex))
      )
    )
  )
)