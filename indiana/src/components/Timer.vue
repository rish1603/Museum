<template>
    <div class="circle">
        {{time}}
    </div>
</template>

<script>
export default {
    name: 'Timer',
    props: ['time']
}
</script>

<style scoped>
.circle {
    border: 5px white solid;
    border-radius: 100px;
    width: 30px;
    padding: 10px;
    margin: 10px auto;
}
</style>
