new Vue({
    el: '#galleryApp',
    data() {
        return {
            urls: []
        }
    },
    mounted() {
        axios.get("http://localhost:91///images/db/images/add")
            .then(response => (console.log(response)))

        setTimeout(() => {

            axios.get("http://localhost:91//images/url")
                .then(response => (this.urls = response.data))

                console.log("images loaded")
                const loader = document.getElementById("loader");
            loader.style.height = 0;
            loader.style.width = 0;
            loader.style.visibility = "hidden"
            console.log(this.urls)

            return this.urls

            
            
        }, Math.random() * 1000 + 500);

        

        console.log("loading images")


    }
})