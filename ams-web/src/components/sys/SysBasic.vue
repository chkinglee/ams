<template>
  <div style="margin-top: 10px">
    <el-tabs v-model="defaultTab" type="card">
      <el-tab-pane label="菜单管理" name="menuMana">
        <menu-mana></menu-mana>
      </el-tab-pane>
      <el-tab-pane label="学院专业管理" name="menuMana">
        <menu-mana></menu-mana>
      </el-tab-pane>
      <el-tab-pane label="文章类型设置" name="menuMana">
        <menu-mana></menu-mana>
      </el-tab-pane>
<!--      <el-tab-pane label="职位管理" name="positionMana">-->
<!--        <pos-mana state="position"></pos-mana>-->
<!--      </el-tab-pane>-->
<!--      <el-tab-pane label="职称管理" name="jobTitleMana">-->
<!--        <pos-mana state="jobtitle"></pos-mana>-->
<!--      </el-tab-pane>-->
<!--      <el-tab-pane label="奖惩规则" name="ecCfg">-->
<!--        <ec-mana></ec-mana>-->
<!--      </el-tab-pane>-->
      <el-tab-pane label="权限组" name="menuRole">
        <menu-role></menu-role>
      </el-tab-pane>
      <el-tab-pane label="用户管理" name="menuMana">
        <menu-mana></menu-mana>
      </el-tab-pane>
      <el-tab-pane label="学生管理" name="menuMana">
        <menu-mana></menu-mana>
      </el-tab-pane>
      <el-tab-pane label="教师管理" name="menuMana">
        <menu-mana></menu-mana>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
  import MenuRole from './basic/MenuRole.vue'
  import Menu from './basic/Menu.vue'
  // import ECMana from './basic/ECMana.vue'
  // import JobTitleMana from './basic/JobTitleMana.vue'
  // import PosMana from './basic/PosMana.vue'
  export default {
    data() {
      return {
        defaultTab: 'menuRole'
      };
    },
    methods: {},
    components: {
      'menu-role': MenuRole,
      'menu-mana': Menu,
      // 'ec-mana': ECMana,
      // 'jobtitle-mana': JobTitleMana,
      // 'pos-mana': PosMana
    }
  };
</script>
