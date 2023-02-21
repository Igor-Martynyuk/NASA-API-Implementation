package com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws.dto.nested

import com.squareup.moshi.Json

data class ResponseNeoOrbitalData(
    @field:Json(name = "aphelion_distance") val aphelionDistance: String,
    @field:Json(name = "ascending_node_longitude") val ascendingNodeLongitude: String,
    @field:Json(name = "data_arc_in_days") val dataArcInDays: Int,
    @field:Json(name = "eccentricity") val Eccentricity: String,
    @field:Json(name = "epoch_osculation") val epochOsculation: String,
    @field:Json(name = "equinox") val Equinox: String,
    @field:Json(name = "first_observation_date") val firstObservationDate: String,
    @field:Json(name = "inclination") val inclination: String,
    @field:Json(name = "jupiter_tisserand_invariant") val jupiterTisserandInvariant: String,
    @field:Json(name = "last_observation_date") val lastObservationDate: String,
    @field:Json(name = "mean_anomaly") val meanAnomaly: String,
    @field:Json(name = "mean_motion") val meanMotion: String,
    @field:Json(name = "minimum_orbit_intersection") val minimumOrbitIntersection: String,
    @field:Json(name = "observations_used") val observationsUsed: Int,
    @field:Json(name = "orbit_class") val orbitClass: ResponseNeoOrbitClass,
    @field:Json(name = "orbit_determination_date") val orbitDeterminationDate: String,
    @field:Json(name = "orbit_id") val orbitId: String,
    @field:Json(name = "orbit_uncertainty") val orbitUncertainty: String,
    @field:Json(name = "orbital_period") val orbitalPeriod: String,
    @field:Json(name = "perihelion_argument") val perihelionArgument: String,
    @field:Json(name = "perihelion_distance") val perihelionDistance: String,
    @field:Json(name = "perihelion_time") val perihelionTime: String,
    @field:Json(name = "semi_major_axis") val semiMajorAxis: String
)