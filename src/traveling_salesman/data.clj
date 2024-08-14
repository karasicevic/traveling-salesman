(ns traveling-salesman.data)

(def cities ["Beograd" "Novi Sad" "Niš" "Kragujevac" "Mladenovac" "Užice" "Zaječar"
             "Subotica" "Sombor" "Pančevo" "Smederevo" "Leskovac" "Vranje"
             "Šabac" "Valjevo" "Loznica" "Požarevac" "Jagodina" "Čačak" "Kraljevo"])

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
                ["Užice" "Zaječar"] 171
                ["Beograd" "Subotica"] 186
                ["Beograd" "Sombor"] 175
                ["Beograd" "Pančevo"] 18
                ["Beograd" "Smederevo"] 46
                ["Beograd" "Leskovac"] 278
                ["Beograd" "Vranje"] 349
                ["Beograd" "Šabac"] 86
                ["Beograd" "Valjevo"] 97
                ["Beograd" "Loznica"] 139
                ["Beograd" "Požarevac"] 80
                ["Beograd" "Jagodina"] 136
                ["Beograd" "Čačak"] 140
                ["Beograd" "Kraljevo"] 175
                ["Novi Sad" "Subotica"] 99
                ["Novi Sad" "Sombor"] 67
                ["Novi Sad" "Pančevo"] 108
                ["Novi Sad" "Smederevo"] 132
                ["Novi Sad" "Leskovac"] 310
                ["Novi Sad" "Vranje"] 381
                ["Novi Sad" "Šabac"] 64
                ["Novi Sad" "Valjevo"] 102
                ["Novi Sad" "Loznica"] 145
                ["Novi Sad" "Požarevac"] 149
                ["Novi Sad" "Jagodina"] 180
                ["Novi Sad" "Čačak"] 185
                ["Novi Sad" "Kraljevo"] 220
                ["Niš" "Subotica"] 328
                ["Niš" "Sombor"] 317
                ["Niš" "Pančevo"] 229
                ["Niš" "Smederevo"] 195
                ["Niš" "Leskovac"] 45
                ["Niš" "Vranje"] 88
                ["Niš" "Šabac"] 273
                ["Niš" "Valjevo"] 233
                ["Niš" "Loznica"] 283
                ["Niš" "Požarevac"] 170
                ["Niš" "Jagodina"] 113
                ["Niš" "Čačak"] 175
                ["Niš" "Kraljevo"] 149
                ["Kragujevac" "Subotica"] 247
                ["Kragujevac" "Sombor"] 236
                ["Kragujevac" "Pančevo"] 119
                ["Kragujevac" "Smederevo"] 65
                ["Kragujevac" "Leskovac"] 135
                ["Kragujevac" "Vranje"] 206
                ["Kragujevac" "Šabac"] 155
                ["Kragujevac" "Valjevo"] 135
                ["Kragujevac" "Loznica"] 165
                ["Kragujevac" "Požarevac"] 90
                ["Kragujevac" "Jagodina"] 43
                ["Kragujevac" "Čačak"] 65
                ["Kragujevac" "Kraljevo"] 53
                ["Mladenovac" "Subotica"] 234
                ["Mladenovac" "Sombor"] 223
                ["Mladenovac" "Pančevo"] 82
                ["Mladenovac" "Smederevo"] 37
                ["Mladenovac" "Leskovac"] 180
                ["Mladenovac" "Vranje"] 251
                ["Mladenovac" "Šabac"] 114
                ["Mladenovac" "Valjevo"] 96
                ["Mladenovac" "Loznica"] 138
                ["Mladenovac" "Požarevac"] 57
                ["Mladenovac" "Jagodina"] 100
                ["Mladenovac" "Čačak"] 125
                ["Mladenovac" "Kraljevo"] 160
                ["Užice" "Subotica"] 334
                ["Užice" "Sombor"] 290
                ["Užice" "Pančevo"] 210
                ["Užice" "Smederevo"] 180
                ["Užice" "Leskovac"] 220
                ["Užice" "Vranje"] 291
                ["Užice" "Šabac"] 157
                ["Užice" "Valjevo"] 101
                ["Užice" "Loznica"] 125
                ["Užice" "Požarevac"] 172
                ["Užice" "Jagodina"] 150
                ["Užice" "Čačak"] 70
                ["Užice" "Kraljevo"] 115
                ["Zaječar" "Subotica"] 313
                ["Zaječar" "Sombor"] 302
                ["Zaječar" "Pančevo"] 208
                ["Zaječar" "Smederevo"] 143
                ["Zaječar" "Leskovac"] 185
                ["Zaječar" "Vranje"] 255
                ["Zaječar" "Šabac"] 264
                ["Zaječar" "Valjevo"] 224
                ["Zaječar" "Loznica"] 274
                ["Zaječar" "Požarevac"] 150
                ["Zaječar" "Jagodina"] 125
                ["Zaječar" "Čačak"] 220
                ["Zaječar" "Kraljevo"] 195
                ["Subotica" "Sombor"] 46
                ["Subotica" "Pančevo"] 172
                ["Subotica" "Smederevo"] 212
                ["Subotica" "Leskovac"] 363
                ["Subotica" "Vranje"] 433
                ["Subotica" "Šabac"] 117
                ["Subotica" "Valjevo"] 185
                ["Subotica" "Loznica"] 225
                ["Subotica" "Požarevac"] 234
                ["Subotica" "Jagodina"] 265
                ["Subotica" "Čačak"] 295
                ["Subotica" "Kraljevo"] 330
                ["Sombor" "Pančevo"] 161
                ["Sombor" "Smederevo"] 201
                ["Sombor" "Leskovac"] 352
                ["Sombor" "Vranje"] 422
                ["Sombor" "Šabac"] 106
                ["Sombor" "Valjevo"] 174
                ["Sombor" "Loznica"] 214
                ["Sombor" "Požarevac"] 223
                ["Sombor" "Jagodina"] 254
                ["Sombor" "Čačak"] 284
                ["Sombor" "Kraljevo"] 319
                ["Pančevo" "Smederevo"] 53
                ["Pančevo" "Leskovac"] 232
                ["Pančevo" "Vranje"] 303
                ["Pančevo" "Šabac"] 122
                ["Pančevo" "Valjevo"] 141
                ["Pančevo" "Loznica"] 181
                ["Pančevo" "Požarevac"] 57
                ["Pančevo" "Jagodina"] 147
                ["Pančevo" "Čačak"] 190
                ["Pančevo" "Kraljevo"] 225
                ["Smederevo" "Leskovac"] 197
                ["Smederevo" "Vranje"] 268
                ["Smederevo" "Šabac"] 85
                ["Smederevo" "Valjevo"] 130
                ["Smederevo" "Loznica"] 165
                ["Smederevo" "Požarevac"] 40
                ["Smederevo" "Jagodina"] 75
                ["Smederevo" "Čačak"] 110
                ["Smederevo" "Kraljevo"] 145
                ["Leskovac" "Vranje"] 70
                ["Leskovac" "Šabac"] 305
                ["Leskovac" "Valjevo"] 265
                ["Leskovac" "Loznica"] 305
                ["Leskovac" "Požarevac"] 200
                ["Leskovac" "Jagodina"] 155
                ["Leskovac" "Čačak"] 185
                ["Leskovac" "Kraljevo"] 195
                ["Vranje" "Šabac"] 375
                ["Vranje" "Valjevo"] 335
                ["Vranje" "Loznica"] 375
                ["Vranje" "Požarevac"] 270
                ["Vranje" "Jagodina"] 225
                ["Vranje" "Čačak"] 255
                ["Vranje" "Kraljevo"] 265
                ["Šabac" "Valjevo"] 54
                ["Šabac" "Loznica"] 82
                ["Šabac" "Požarevac"] 125
                ["Šabac" "Jagodina"] 160
                ["Šabac" "Čačak"] 155
                ["Šabac" "Kraljevo"] 190
                ["Valjevo" "Loznica"] 60
                ["Valjevo" "Požarevac"] 155
                ["Valjevo" "Jagodina"] 120
                ["Valjevo" "Čačak"] 75
                ["Valjevo" "Kraljevo"] 110
                ["Loznica" "Požarevac"] 195
                ["Loznica" "Jagodina"] 230
                ["Loznica" "Čačak"] 125
                ["Loznica" "Kraljevo"] 160
                ["Požarevac" "Jagodina"] 43
                ["Požarevac" "Čačak"] 145
                ["Požarevac" "Kraljevo"] 180
                ["Jagodina" "Čačak"] 108
                ["Jagodina" "Kraljevo"] 43
                ["Čačak" "Kraljevo"] 35})
