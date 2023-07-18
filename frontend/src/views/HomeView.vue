<template>
  <div>
    <button @click="getData">데이터 호출</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'HomeView',
  methods: {
    getData() {
      axios
          .get("http://localhost:8080/api")
          .then((response) => {
            console.log(response)
          })
          .catch((error) => {
            console.log(error)
          })
    }
  }
}
</script>
