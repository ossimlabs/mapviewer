package mapviewer

class HelloController {

    def index() {
        String name = params?.name ?: 'World'
        String messege = "Hello ${name}!  ${new Date()}"
       render contentType: 'text/plain', text: messege
        
        // [messege: messege]
    }
}
