(ns traveling-salesman.data)

(def cities ["Beograd" "Novi Sad" "Niš" "Kragujevac" "Mladenovac" "Užice" "Zaječar"])

(def distances {["Beograd" "Novi Sad"] 93
                ["Beograd" "Niš"] 237
                ["Beograd" "Kragujevac"] 120
                ["Beograd" "Mladenovac"] 55
                ["Beograd" "Užice"] 192
                ["Beograd" "Zaječar"] 240
                ["Novi Sad" "Niš"] 170
                ["Novi Sad" "Kragujevac"] 110
                ["Novi Sad" "Mladenovac"] 134
                ["Novi Sad" "Užice"] 268
                ["Novi Sad" "Zaječar"] 188
                ["Niš" "Kragujevac"] 132
                ["Niš" "Mladenovac"] 189
                ["Niš" "Užice"] 235
                ["Niš" "Zaječar"] 183
                ["Kragujevac" "Mladenovac"] 90
                ["Kragujevac" "Užice"] 158
                ["Kragujevac" "Zaječar"] 200
                ["Mladenovac" "Užice"] 103
                ["Mladenovac" "Zaječar"] 176
                ["Užice" "Zaječar"] 171})