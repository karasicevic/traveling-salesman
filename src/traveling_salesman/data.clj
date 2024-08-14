(ns traveling-salesman.data)

(def cities ["Beograd" "Novi Sad" "Nis" "Kragujevac" "Mladenovac" "Uzice" "Zajecar"
             "Subotica" "Sombor" "Pancevo" "Smederevo" "Leskovac" "Vranje"
             "Sabac" "Valjevo" "Loznica" "Pozarevac" "Jagodina" "Cacak" "Kraljevo"])

(def distances {["Beograd" "Novi Sad"] 93
                ["Beograd" "Nis"] 237
                ["Beograd" "Kragujevac"] 120
                ["Beograd" "Mladenovac"] 55
                ["Beograd" "Uzice"] 192
                ["Beograd" "Zajecar"] 240
                ["Novi Sad" "Nis"] 170
                ["Novi Sad" "Kragujevac"] 110
                ["Novi Sad" "Mladenovac"] 134
                ["Novi Sad" "Uzice"] 268
                ["Novi Sad" "Zajecar"] 188
                ["Nis" "Kragujevac"] 132
                ["Nis" "Mladenovac"] 189
                ["Nis" "Uzice"] 235
                ["Nis" "Zajecar"] 183
                ["Kragujevac" "Mladenovac"] 90
                ["Kragujevac" "Uzice"] 158
                ["Kragujevac" "Zajecar"] 200
                ["Mladenovac" "Uzice"] 103
                ["Mladenovac" "Zajecar"] 176
                ["Uzice" "Zajecar"] 171
                ["Beograd" "Subotica"] 186
                ["Beograd" "Sombor"] 175
                ["Beograd" "Pancevo"] 18
                ["Beograd" "Smederevo"] 46
                ["Beograd" "Leskovac"] 278
                ["Beograd" "Vranje"] 349
                ["Beograd" "Sabac"] 86
                ["Beograd" "Valjevo"] 97
                ["Beograd" "Loznica"] 139
                ["Beograd" "Pozarevac"] 80
                ["Beograd" "Jagodina"] 136
                ["Beograd" "Cacak"] 140
                ["Beograd" "Kraljevo"] 175
                ["Novi Sad" "Subotica"] 99
                ["Novi Sad" "Sombor"] 67
                ["Novi Sad" "Pancevo"] 108
                ["Novi Sad" "Smederevo"] 132
                ["Novi Sad" "Leskovac"] 310
                ["Novi Sad" "Vranje"] 381
                ["Novi Sad" "Sabac"] 64
                ["Novi Sad" "Valjevo"] 102
                ["Novi Sad" "Loznica"] 145
                ["Novi Sad" "Pozarevac"] 149
                ["Novi Sad" "Jagodina"] 180
                ["Novi Sad" "Cacak"] 185
                ["Novi Sad" "Kraljevo"] 220
                ["Nis" "Subotica"] 328
                ["Nis" "Sombor"] 317
                ["Nis" "Pancevo"] 229
                ["Nis" "Smederevo"] 195
                ["Nis" "Leskovac"] 45
                ["Nis" "Vranje"] 88
                ["Nis" "Sabac"] 273
                ["Nis" "Valjevo"] 233
                ["Nis" "Loznica"] 283
                ["Nis" "Pozarevac"] 170
                ["Nis" "Jagodina"] 113
                ["Nis" "Cacak"] 175
                ["Nis" "Kraljevo"] 149
                ["Kragujevac" "Subotica"] 247
                ["Kragujevac" "Sombor"] 236
                ["Kragujevac" "Pancevo"] 119
                ["Kragujevac" "Smederevo"] 65
                ["Kragujevac" "Leskovac"] 135
                ["Kragujevac" "Vranje"] 206
                ["Kragujevac" "Sabac"] 155
                ["Kragujevac" "Valjevo"] 135
                ["Kragujevac" "Loznica"] 165
                ["Kragujevac" "Pozarevac"] 90
                ["Kragujevac" "Jagodina"] 43
                ["Kragujevac" "Cacak"] 65
                ["Kragujevac" "Kraljevo"] 53
                ["Mladenovac" "Subotica"] 234
                ["Mladenovac" "Sombor"] 223
                ["Mladenovac" "Pancevo"] 82
                ["Mladenovac" "Smederevo"] 37
                ["Mladenovac" "Leskovac"] 180
                ["Mladenovac" "Vranje"] 251
                ["Mladenovac" "Sabac"] 114
                ["Mladenovac" "Valjevo"] 96
                ["Mladenovac" "Loznica"] 138
                ["Mladenovac" "Pozarevac"] 57
                ["Mladenovac" "Jagodina"] 100
                ["Mladenovac" "Cacak"] 125
                ["Mladenovac" "Kraljevo"] 160
                ["Uzice" "Subotica"] 334
                ["Uzice" "Sombor"] 290
                ["Uzice" "Pancevo"] 210
                ["Uzice" "Smederevo"] 180
                ["Uzice" "Leskovac"] 220
                ["Uzice" "Vranje"] 291
                ["Uzice" "Sabac"] 157
                ["Uzice" "Valjevo"] 101
                ["Uzice" "Loznica"] 125
                ["Uzice" "Pozarevac"] 172
                ["Uzice" "Jagodina"] 150
                ["Uzice" "Cacak"] 70
                ["Uzice" "Kraljevo"] 115
                ["Zajecar" "Subotica"] 313
                ["Zajecar" "Sombor"] 302
                ["Zajecar" "Pancevo"] 208
                ["Zajecar" "Smederevo"] 143
                ["Zajecar" "Leskovac"] 185
                ["Zajecar" "Vranje"] 255
                ["Zajecar" "Sabac"] 264
                ["Zajecar" "Valjevo"] 224
                ["Zajecar" "Loznica"] 274
                ["Zajecar" "Pozarevac"] 150
                ["Zajecar" "Jagodina"] 125
                ["Zajecar" "Cacak"] 220
                ["Zajecar" "Kraljevo"] 195
                ["Subotica" "Sombor"] 46
                ["Subotica" "Pancevo"] 172
                ["Subotica" "Smederevo"] 212
                ["Subotica" "Leskovac"] 363
                ["Subotica" "Vranje"] 433
                ["Subotica" "Sabac"] 117
                ["Subotica" "Valjevo"] 185
                ["Subotica" "Loznica"] 225
                ["Subotica" "Pozarevac"] 234
                ["Subotica" "Jagodina"] 265
                ["Subotica" "Cacak"] 295
                ["Subotica" "Kraljevo"] 330
                ["Sombor" "Pancevo"] 161
                ["Sombor" "Smederevo"] 201
                ["Sombor" "Leskovac"] 352
                ["Sombor" "Vranje"] 422
                ["Sombor" "Sabac"] 106
                ["Sombor" "Valjevo"] 174
                ["Sombor" "Loznica"] 214
                ["Sombor" "Pozarevac"] 223
                ["Sombor" "Jagodina"] 254
                ["Sombor" "Cacak"] 284
                ["Sombor" "Kraljevo"] 319
                ["Pancevo" "Smederevo"] 53
                ["Pancevo" "Leskovac"] 232
                ["Pancevo" "Vranje"] 303
                ["Pancevo" "Sabac"] 122
                ["Pancevo" "Valjevo"] 141
                ["Pancevo" "Loznica"] 181
                ["Pancevo" "Pozarevac"] 57
                ["Pancevo" "Jagodina"] 147
                ["Pancevo" "Cacak"] 190
                ["Pancevo" "Kraljevo"] 225
                ["Smederevo" "Leskovac"] 197
                ["Smederevo" "Vranje"] 268
                ["Smederevo" "Sabac"] 85
                ["Smederevo" "Valjevo"] 130
                ["Smederevo" "Loznica"] 165
                ["Smederevo" "Pozarevac"] 40
                ["Smederevo" "Jagodina"] 75
                ["Smederevo" "Cacak"] 110
                ["Smederevo" "Kraljevo"] 145
                ["Leskovac" "Vranje"] 70
                ["Leskovac" "Sabac"] 305
                ["Leskovac" "Valjevo"] 265
                ["Leskovac" "Loznica"] 305
                ["Leskovac" "Pozarevac"] 200
                ["Leskovac" "Jagodina"] 155
                ["Leskovac" "Cacak"] 185
                ["Leskovac" "Kraljevo"] 195
                ["Vranje" "Sabac"] 375
                ["Vranje" "Valjevo"] 335
                ["Vranje" "Loznica"] 375
                ["Vranje" "Pozarevac"] 270
                ["Vranje" "Jagodina"] 225
                ["Vranje" "Cacak"] 255
                ["Vranje" "Kraljevo"] 265
                ["Sabac" "Valjevo"] 54
                ["Sabac" "Loznica"] 82
                ["Sabac" "Pozarevac"] 125
                ["Sabac" "Jagodina"] 160
                ["Sabac" "Cacak"] 155
                ["Sabac" "Kraljevo"] 190
                ["Valjevo" "Loznica"] 60
                ["Valjevo" "Pozarevac"] 155
                ["Valjevo" "Jagodina"] 120
                ["Valjevo" "Cacak"] 75
                ["Valjevo" "Kraljevo"] 110
                ["Loznica" "Pozarevac"] 195
                ["Loznica" "Jagodina"] 230
                ["Loznica" "Cacak"] 125
                ["Loznica" "Kraljevo"] 160
                ["Pozarevac" "Jagodina"] 43
                ["Pozarevac" "Cacak"] 145
                ["Pozarevac" "Kraljevo"] 180
                ["Jagodina" "Cacak"] 108
                ["Jagodina" "Kraljevo"] 43
                ["Cacak" "Kraljevo"] 35})
