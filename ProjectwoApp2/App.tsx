import React, { Component } from 'react';
import { SafeAreaView } from 'react-native';
import WebView from 'react-native-webview';


const App = () => {
  return (
    <SafeAreaView style={{flex: 1}}>
      <WebView source={{ uri: 'https://groupprojectwo.io' }}/>
    </SafeAreaView>
  )
}

export default App;