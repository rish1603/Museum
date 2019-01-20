<template>
    <div id="Leaderboard" class="route">
        <h1>Leaderboard</h1>
        <div v-for="(team, i) in teams" :key="i">
            <h2>{{team.teamName}}</h2>
            <svg width=150 height=20>
                <rect width="150" height="20" rx="10" fill="white"/>
                <rect y=2 x=2 :width="(team.score/10)*146" height="16" rx="10" fill="#5FAFFF"/>
            </svg>
            <p>{{team.score}}/10</p>
        </div>
    </div>
</template>

<script>
import { apiUrl } from '@/consts.js'

export default {
    name: 'Leaderboard',
    data() {
        return {
            teams: [
                { teamName: 'Team one', score: 3 },
                { teamName: 'Team two', score: 1 }
            ]
        }
    },
    async created() {
      const resp = await fetch(`${apiUrl}/teams`)
      const json = await resp.json()
      this.teams = json.sort((a,b) => b.score - a.score)
    }
}
</script>
