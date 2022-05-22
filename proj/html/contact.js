function disableScroll() {
    // Get the current page scroll position
    scrollTop = window.pageYOffset || document.documentElement.scrollTop;
    scrollLeft = window.pageXOffset || document.documentElement.scrollLeft,

        // if any scroll is attempted, set this to the previous value
        window.onscroll = function () {
            window.scrollTo(scrollLeft, scrollTop);
        };
}

new Vue({
    el: '#content',
    data() {
        return {
            options: [],
            name: "",
            mail: "",
            subject: "",
            message: ""

        }
    },
    mounted() {
        axios.get("http://localhost:91/options/getAll")
            .then(response => (this.options = response.data))


    },
    methods: {
        print: function () {
            axios.get("http://localhost:91/questions/addQuestion?name=" + this.name + "&mail=" + this.mail + "&subject=" + this.subject + "&message=" + this.message)
        }
    }
})
