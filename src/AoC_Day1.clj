(ns AdventOfCode.AoC_Day1)


(def spaceShipMassList  [125860
                      66059
                      147392
                      64447
                      72807
                      136018
                      144626
                      68233
                      130576
                      92645
                      52805
                      79642
                      74361
                      98270
                      110796
                      62578
                      58421
                      125079
                      52683
                      144885
                      148484
                      113638
                      125026
                      112534
                      125479
                      51539
                      122007
                      60048
                      67923
                      76115
                      144822
                      115991
                      133505
                      85249
                      142441
                      90211
                      87022
                      68196
                      117577
                      58112
                      116865
                      108253
                      127674
                      93302
                      58817
                      126794
                      89824
                      134386
                      99700
                      125855
                      119753
                      64456
                      68167
                      88047
                      127864
                      146890
                      71912
                      128375
                      134365
                      91544
                      104179
                      84700
                      95937
                      78409
                      94604
                      130423
                      98348
                      87489
                      105103
                      94794
                      123723
                      134298
                      88283
                      59543
                      53645
                      89325
                      109301
                      143668
                      96250
                      130371
                      140436
                      95857
                      98543
                      91372
                      137056
                      142578
                      116185
                      96588
                      93025
                      122275
                      99201
                      110492
                      109700
                      106755
                      120979
                      60957
                      134983
                      130840
                      132329
                      65057]
)

(defn mass-to-fuel
  "Returns the fuel needed for a given mass.
  Divides the mass by three, casts to int (which rounds down), then subtracts 2."
  [mass]
  (if (< mass 9)
    0
    (-> mass
        (/ 3)
        int
        (- 2)
    )
  )
)

(defn recursive-mass-to-fuel
  "Returns the fuel needed for a given mass accounting for the mass of the fuel being added."
  [mass]
  (loop [fuelMass (mass-to-fuel mass)
         totalFuelMass 0]
    (if (pos? fuelMass)
      (recur (mass-to-fuel fuelMass) (+ totalFuelMass fuelMass))
      totalFuelMass
    )
  )
)

(defn mass-list-to-fuel-list
  "Returns a list of fuel amounts needed based off of a list of masses.
  Does not account for the mass of the fuel that is calculated."
  [massList]
  (map recursive-mass-to-fuel massList)
)

(defn recursive-mass-list-to-fuel-list-calculation
  ""
  [massList]
  (map recursive-mass-to-fuel massList)
)

(defn complete-fuel-calculation
  "Calculates the required fuel for a list of masses accounting
  for the mass of the fuel that is calculated."
  [massList]
  (apply + (recursive-mass-list-to-fuel-list-calculation massList))
)