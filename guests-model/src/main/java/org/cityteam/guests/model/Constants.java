/*
 * Copyright 2020 CityTeam, craigmcc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cityteam.guests.model;

/**
 * <p>Manifest constants for columns and tables.</p>
 */
public interface Constants extends org.craigmcc.library.model.Constants {

    // Per-Column Constants

    String ABBREVIATION_COLUMN = "abbreviation";
    String ABBREVIATION_VALIDATION_MESSAGE =
            "abbreviation: Required and must not be blank";

    String ADDRESS1_COLUMN = "address1";

    String ADDRESS2_COLUMN = "address2";

    String CITY_COLUMN = "city";

    String STATE_COLUMN = "state";

    String ZIPCODE_COLUMN = "zipCode";

    // Per-Table Constants

    String FACILITY_NAME = "Facility";
    String FACILITY_TABLE = "facilities";

}
