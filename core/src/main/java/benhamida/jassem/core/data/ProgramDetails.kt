package benhamida.jassem.core.data

class ProgramDetailsDTO {
    var template: String? = null
    var parentalrating: Long = 0
    var categoryID: Long = 0
    var contents: ProgramDetails? = null
}

class ProgramDetails {
    var id: String? = null
    var title = ArrayList<Description>()
    var highlightid: String? = null
    var selectid: String? = null
    var isbookmarkable = false
    var detaillink: String? = null
    var seasons = ArrayList<Season>()
    var acontents = ArrayList<Content>()
}

class Season {
    var id: String? = null
    var menutitle = ArrayList<Description>()
    var subtitle: String? = null
    var number: Long = 0
    var pitch: String? = null
    var imageurl: String? = null
    var isbookmarkable = false
    var episodes = ArrayList<Any>()
    var highlefticon = ArrayList<Any>()
    var acontents = ArrayList<Any>()
}

class Content {
    var type: String? = null
    var description = ArrayList<Description>()
    var link: String? = null
    var imageurl: String? = null
    var contents = ArrayList<Program>()
}