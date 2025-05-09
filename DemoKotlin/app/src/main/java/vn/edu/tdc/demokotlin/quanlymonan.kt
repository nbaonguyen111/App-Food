package vn.edu.tdc.demokotlin
import androidx.lifecycle.MutableLiveData
object quanlymonan {
    val foodList = mutableListOf<outDatacomota>()
    val foodListLiveData: MutableLiveData<List<outDatacomota>> = MutableLiveData()

    init {
        initFoodList()
    }

    fun initFoodList() {
        if (foodList.isEmpty()) {
            foodList.add(
                outDatacomota(
                    R.drawable.icboluclac,
                    "Bò Lúc Lắc",
                    75000.0,
                    "Món ăn với thịt bò xào mềm, đậm đà hương vị đặc trưng.",
                    "Bò Gà Vịt"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.icbobeeftsteack,
                    "Bò Beef Steak",
                    95000.0,
                    "Bò nướng dày, thịt mềm, kết hợp với sốt đặc biệt.",
                    "Bò Gà Vịt"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.icgaumuoi,
                    "Gà Ủ Muối",
                    60000.0,
                    "Gà nướng mềm, mặn mà với gia vị muối đặc trưng.",
                    "Bò Gà Vịt"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.icvitquay,
                    "Vịt Quay",
                    85000.0,
                    "Vịt quay giòn, da vàng ruộm, thịt thơm ngọt.",
                    "Bò Gà Vịt"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.icvittiem,
                    "Vịt Tiềm",
                    80000.0,
                    "Vịt nấu tiềm với gia vị hầm mềm, thơm ngon.",
                    "Bò Gà Vịt"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.icbotaichanh,
                    "Bò Tái Chanh",
                    70000.0,
                    "Bò tái chín mềm, kết hợp với nước chanh tươi mát.",
                    "Bò Gà Vịt"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.icgahapbia,
                    "Gà Hấp Bia",
                    65000.0,
                    "Gà hấp bia mềm, thơm ngon, rất đậm đà.",
                    "Bò Gà Vịt"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.icgaxephay,
                    "Gà Xé Phay",
                    55000.0,
                    "Gà xé phay ăn kèm với rau sống, gia vị chua ngọt.",
                    "Bò Gà Vịt"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.icgoivit,
                    "Gỏi Vịt",
                    70000.0,
                    "Gỏi vịt tươi mát, kèm rau thơm và gia vị.",
                    "Bò Gà Vịt"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.longgasuhao,
                    "Lòng Gà Xào Su Hào",
                    45000.0,
                    "Lòng gà xào su hào giòn giòn, kết hợp gia vị đặc trưng.",
                    "Bò Gà Vịt"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.mamchungrau,
                    "Mắm Chưng Rau Sống",
                    35000.0,
                    "Mắm chưng ăn kèm rau sống tươi mát, phù hợp với khẩu vị người Việt.",
                    "Bò Gà Vịt"
                )
            )

            foodList.add(
                outDatacomota(
                    R.drawable.travailai,
                    "Trà Vải Lài",
                    35000.0,
                    "Trà vải thơm mát kết hợp với hương vải lài đặc trưng.",
                    "Đồ Uống"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.tradaocamsa,
                    "Trà Đào Cam Sả",
                    40000.0,
                    "Trà đào kết hợp với cam và sả tạo nên hương vị tươi mới.",
                    "Đồ Uống"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.trasuaphuclong,
                    "Trà Sữa Phúc Long",
                    45000.0,
                    "Trà sữa Phúc Long nổi tiếng với hương vị béo ngậy và thơm ngon.",
                    "Đồ Uống"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.traolongmangcau,
                    "Trà Ô Long Mãng Cầu",
                    42000.0,
                    "Trà Ô Long kết hợp với mãng cầu chua ngọt, refreshing.",
                    "Đồ Uống"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.pepsi,
                    "Pepsi",
                    25000.0,
                    "Pepsi – nước giải khát sảng khoái, vị ngọt đặc trưng.",
                    "Đồ Uống"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.siting,
                    "Siting",
                    26000.0,
                    "Siting – nước giải khát với hương vị tươi mới, sảng khoái.",
                    "Đồ Uống"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.ic_trasuatruyenthong,
                    "Trà Sữa Truyền Thống",
                    38000.0,
                    "Trà sữa truyền thống với vị ngọt béo đặc trưng.",
                    "Đồ Uống"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.ic_milodam,
                    "MiLo Dầm",
                    30000.0,
                    "MiLo dầm kết hợp với đá bào, mang đến vị ngọt béo mát lạnh.",
                    "Đồ Uống"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.ic_strongbow,
                    "Strong Bow",
                    55000.0,
                    "Strong Bow – rượu táo có vị ngọt, dễ uống, thích hợp cho mọi dịp.",
                    "Đồ Uống"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.ic_biatiger,
                    "Bia Tiger",
                    13000.0,
                    "Bia Tiger – bia nổi tiếng với vị đậm đà, phù hợp cho những bữa tiệc.",
                    "Đồ Uống"
                )
            )

            foodList.add(
                outDatacomota(
                    R.drawable.haumohanh,
                    "Hàu Mỡ Hành",
                    35000.0,
                    "Hàu tươi được nướng với mỡ hành thơm lừng, ngon miệng.",
                    "Hải Sản"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.haonuongphomai,
                    "Hàu Phô Mai",
                    45000.0,
                    "Hàu nướng phô mai béo ngậy, hấp dẫn vị giác.",
                    "Hải Sản"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.ocbu,
                    "Ốc Bưu",
                    28000.0,
                    "Ốc bưu được chế biến đậm đà, tươi ngon với gia vị đặc trưng.",
                    "Hải Sản"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.ochuong,
                    "Ốc Hương",
                    32000.0,
                    "Ốc hương tươi sống xào gia vị, giòn ngọt, hấp dẫn.",
                    "Hải Sản"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.ocmongtay,
                    "Ốc Móng Tay",
                    29000.0,
                    "Ốc móng tay xào tỏi thơm, vị ngọt tự nhiên của hải sản.",
                    "Hải Sản"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.sodiep,
                    "Sò Điệp",
                    48000.0,
                    "Sò điệp nướng bơ tỏi hoặc xào, ngọt thịt, hấp dẫn.",
                    "Hải Sản"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.tomhumbotoi,
                    "Tôm Hùm Bơ Tỏi",
                    180000.0,
                    "Tôm hùm nướng bơ tỏi, vị ngọt thanh, béo ngậy.",
                    "Hải Sản"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.tomxaothapcam,
                    "Tôm Xào Thập Cẩm",
                    35000.0,
                    "Tôm xào với rau củ thập cẩm, thơm ngon, đầy đủ dưỡng chất.",
                    "Hải Sản"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.kingcrabbotoi,
                    "KingCrab Bơ Tỏi",
                    250000.0,
                    "Càng cua hoàng đế nướng bơ tỏi, giòn ngọt đậm đà.",
                    "Hải Sản"
                )
            )
            foodList.add(
                outDatacomota(
                    R.drawable.ghengamtuong,
                    "Ghẹ Ngâm Tương",
                    40000.0,
                    "Ghẹ ngâm tương, vị đậm đà, thơm ngon, rất đặc biệt.",
                    "Hải Sản"
                )
            )
        foodListLiveData.value = foodList
        }
    }

    fun getDSFood(): List<outDatacomota> {
        return foodList
    }

    fun addFood(food: outDatacomota) {
        foodList.add(food)
        foodListLiveData.value = foodList
    }

    fun editFood(position: Int, newFood: outDatacomota) {
        foodList[position] = newFood
        foodListLiveData.value = foodList
    }

    fun updateFood(position: Int, updatedFood: outDatacomota) {
        if (position in foodList.indices) {
            foodList[position] = updatedFood
            foodListLiveData.value = foodList
        }
    }
        fun deleteFood(position: Int) {
            foodList.removeAt(position)
            foodListLiveData.value = foodList
        }
}
