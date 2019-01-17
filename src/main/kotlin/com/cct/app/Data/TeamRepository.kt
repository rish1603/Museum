package com.cct.app.Data

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component


@Component
interface TeamRepository : MongoRepository<Team, String>
