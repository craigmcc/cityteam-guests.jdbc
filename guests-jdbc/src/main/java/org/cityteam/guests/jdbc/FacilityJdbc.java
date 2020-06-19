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
package org.cityteam.guests.jdbc;

import org.cityteam.guests.model.Facility;
import org.craigmcc.library.model.AbstractModelJdbc;
import org.craigmcc.library.model.Constants;
import org.craigmcc.library.sql.DeleteBuilder;
import org.craigmcc.library.sql.InsertBuilder;
import org.craigmcc.library.sql.MutatingStatementBuilder;
import org.craigmcc.library.sql.SelectBuilder;
import org.craigmcc.library.sql.UpdateBuilder;

import javax.validation.constraints.NotNull;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.cityteam.guests.model.Constants.ABBREVIATION_COLUMN;
import static org.cityteam.guests.model.Constants.ADDRESS1_COLUMN;
import static org.cityteam.guests.model.Constants.ADDRESS2_COLUMN;
import static org.cityteam.guests.model.Constants.CITY_COLUMN;
import static org.cityteam.guests.model.Constants.FACILITY_TABLE;
import static org.cityteam.guests.model.Constants.STATE_COLUMN;
import static org.cityteam.guests.model.Constants.ZIPCODE_COLUMN;
import static org.craigmcc.library.sql.SqlOperator.EQ;

/**
 * <p>JDBC integration for {@link Facility} model objects.</p>
 */
public class FacilityJdbc
        extends AbstractModelJdbc<Facility>
        implements Constants {

    // Public Methods --------------------------------------------------------

    @Override
    public @NotNull PreparedStatement delete(@NotNull Connection connection,
                                             @NotNull Long id)
            throws SQLException {
        return new DeleteBuilder(FACILITY_TABLE)
                .primary(ID_COLUMN, id)
                .build(connection);
    }

    @Override
    public @NotNull PreparedStatement findAll(@NotNull Connection connection)
            throws SQLException {
        return new SelectBuilder(FACILITY_TABLE)
                .all()
                .build(connection);
    }

    public @NotNull PreparedStatement findByAbbreviation(@NotNull Connection connection,
                                                         @NotNull String abbreviation)
            throws SQLException {
        return new SelectBuilder(FACILITY_TABLE)
                .expression(ABBREVIATION_COLUMN, EQ, abbreviation)
                .build(connection);
    }

    @Override
    public @NotNull PreparedStatement findById(@NotNull Connection connection,
                                               @NotNull Long id)
            throws SQLException {
        return new SelectBuilder(FACILITY_TABLE)
                .primary(ID_COLUMN, id)
                .build(connection);
    }

    @Override
    public @NotNull PreparedStatement insert(@NotNull Connection connection,
                                             @NotNull Facility model)
            throws SQLException {
        model.setPublished(LocalDateTime.now());
        model.setUpdated(model.getPublished());
        InsertBuilder builder = new InsertBuilder(FACILITY_TABLE);
        populateFields(builder, model);
        return builder.build(connection);
    }

    @Override
    public Facility populateNext(@NotNull ResultSet resultSet)
            throws SQLException {
        if (!resultSet.next()) {
            return null;
        }
        Facility model = new Facility();
        populateModel(model, resultSet);
        try {
            model.setAbbreviation(resultSet.getString(ABBREVIATION_COLUMN));
        } catch (SQLException e) {
            // Ignore
        }
        try {
            model.setAddress1(resultSet.getString(ADDRESS1_COLUMN));
        } catch (SQLException e) {
            // Ignore
        }
        try {
            model.setAddress2(resultSet.getString(ADDRESS2_COLUMN));
        } catch (SQLException e) {
            // Ignore
        }
        try {
            model.setCity(resultSet.getString(CITY_COLUMN));
        } catch (SQLException e) {
            // Ignore
        }
        try {
            model.setState(resultSet.getString(STATE_COLUMN));
        } catch (SQLException e) {
            // Ignore
        }
        try { // TODO - "zipCode" versus "zipcode"?
            model.setZipCode(resultSet.getString(ZIPCODE_COLUMN));
        } catch (SQLException e) {
            // Ignore
        }

        return model;
    }

    @Override
    public @NotNull PreparedStatement update(@NotNull Connection connection,
                                             @NotNull Facility model)
            throws SQLException {
        model.setPublished(LocalDateTime.now());
        UpdateBuilder builder = new UpdateBuilder(FACILITY_TABLE);
        populateFields(builder, model);
        return builder.build(connection);
    }

    // Protected Methods -----------------------------------------------------

    protected @NotNull void populateFields(@NotNull MutatingStatementBuilder builder,
                                           @NotNull Facility model) {
        builder.pairModel(model);
        builder.pair(ABBREVIATION_COLUMN, model.getAbbreviation());
        builder.pair(ADDRESS1_COLUMN, model.getAddress1());
        builder.pair(ADDRESS2_COLUMN, model.getAddress2());
        builder.pair(CITY_COLUMN, model.getCity());
        builder.pair(STATE_COLUMN, model.getState());
        builder.pair(ZIPCODE_COLUMN, model.getZipCode());
    }

}
