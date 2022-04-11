package dev.bhuvan.composebasic.model

data class MarsPhotoModel(
    val photos : ArrayList<MarsImageDataModel>
)


data class MarsImageDataModel(
    val id: String,
    val sol: Int,
    val img_src: String,
    val camera: CameraModel,
    val earth_date: String,
    val rover: RoverModel
)


data class CameraModel(
    val name: String,
    val full_name: String,
    val rover_id: String
)


data class RoverModel(
    val name: String,
    val status: String
)