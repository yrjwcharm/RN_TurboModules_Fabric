/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React from 'react';
import {Button, SafeAreaView, StyleSheet} from 'react-native';
import NativeLocalStorage from './specs/NativeLocalStorage';
function App(): React.JSX.Element {
  const saveValue = () => {
    NativeLocalStorage.setItem('userName', '张三');
  };
  const deleteValue = () => {
    NativeLocalStorage.removeItem('userName');
  };
  const clearAll = () => {
    NativeLocalStorage.clear();
  };
  return (
    <SafeAreaView style={styles.container}>
      <Button title="保存" onPress={saveValue} /> 
      <Button title="删除" onPress={deleteValue} />
      <Button title="清除" onPress={clearAll} />
    </SafeAreaView>
  );
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});
export default App;
