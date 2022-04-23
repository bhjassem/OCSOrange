package benhamida.jassem.core.data

class ProgramSearchDTO {
    var template: String? = null
    var parentalrating: Long = 0
    var title: String? = null
    var offset: Long = 0
    var limit: String? = null
    var next: String? = null
    var previous: String? = null
    var total: Long = 0
    var count: Long = 0
    var filter: String? = null
    var sort: String? = null
    var contents = ArrayList<Program>()
}

class Program {
    var id: String? = null
    var title = ArrayList<Description>()
    var subtitle: String? = null
    var subtitlefocus: ArrayList<String>? = null
    var highlefticon: ArrayList<String>? = null
    var highrighticon: ArrayList<String>? = null
    var lowrightinfo: String? = null
    var imageurl: String? = null
    var fullscreenimageurl: String? = null
    var detaillink: String? = null
    var duration: String? = null
    var playinfoid: PlayInfoId? = null
    var playinfo: PlayInfo? = null
}

class Description {
    var type: String? = null
    var value: String? = null
    var color: String? = null
}

class PlayInfoId {
    var hd: String? = null
    var sd: String? = null
    var uhd: String? = null
}

class PlayInfo {
    var tokenurl: String? = null
    var url: String? = null
}