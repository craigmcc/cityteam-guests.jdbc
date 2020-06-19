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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.craigmcc.library.model.Model;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotNull;

import static org.cityteam.guests.model.Constants.FACILITY_NAME;

@Schema(
        description = "An individual CityTeam facility.",
        name = FACILITY_NAME
)
public class Facility extends Model<Facility> implements Constants {

    // Instance Variables ----------------------------------------------------

    @Schema(description = "Short abbreviation for this facility.")
    @NotNull(message = ABBREVIATION_VALIDATION_MESSAGE)
    private String abbreviation;

    @Schema(description = "First line of street address for this facility.")
    private String address1;

    @Schema(description = "Second line of street address for this facility.")
    private String address2;

    @Schema(description = "City name for this facility.")
    private String city;

    @Schema(description = "State abbreviation for this facility.")
    private String state;

    @Schema(description = "Zip code for this facility.")
    private String zipCode;

    // Constructors ----------------------------------------------------------

    public Facility() { }

    public Facility(String abbreviation) {
        this(abbreviation, null, null, null, null, null);
    }

    public Facility(
            String abbreviation,
            String address1,
            String address2,
            String city,
            String state,
            String zipCode
    ) {
        this.abbreviation = abbreviation;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Static Methods --------------------------------------------------------

    public static final @NotNull Facility newInstance() {
        return new Facility();
    }

    // Property Methods ------------------------------------------------------

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // Public Methods --------------------------------------------------------

    @Override
    public void copy(Facility from) {
        this.abbreviation = from.abbreviation;
        this.address1 = from.address1;
        this.address2 = from.address2;
        this.city = from.city;
        this.state = from.state;
        this.zipCode = from.zipCode;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Facility)) {
            return false;
        }
        Facility that = (Facility) object;
        return new EqualsBuilder()
                .appendSuper(super.equals(that))
                .append(this.abbreviation, that.abbreviation)
                .append(this.address1, that.address1)
                .append(this.address2, that.address2)
                .append(this.city, that.city)
                .append(this.state, that.state)
                .append(this.zipCode, that.zipCode)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(this.abbreviation)
                .append(this.address1)
                .append(this.address2)
                .append(this.city)
                .append(this.state)
                .append(this.zipCode)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .appendSuper(super.toString())
                .append(ABBREVIATION_COLUMN, this.abbreviation)
                .append(ADDRESS1_COLUMN, this.address1)
                .append(ADDRESS2_COLUMN, this.address2)
                .append(CITY_COLUMN, this.city)
                .append(STATE_COLUMN, this.state)
                .append(ZIPCODE_COLUMN, this.zipCode)
                .toString();
    }

}
