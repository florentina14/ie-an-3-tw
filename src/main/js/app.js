'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {persons: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/persons'}).done(response => {
			this.setState({persons: response.entity._embedded.persons});
		});
	}

	render() {
		return (
			<PersonList persons={this.state.persons}/>
		)
	}
}

class PersonList extends React.Component {
	render() {
		var persons = this.props.persons.map(person =>
			<Person key={person._links.self.href} person={person}/>
		);
		return (
			<div>	
				<h1> Persons: </h1>
				<hr />
				
				<table>
					<tbody>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Addresses</th>
						</tr>
						{persons}
					</tbody>
				</table>
			</div>
		)
	}
}

class Person extends React.Component {
	render() {
		return (
			<tr>
				<td>{this.props.person.firstName}</td>
				<td>{this.props.person.lastName}</td>
				<td>view</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)

