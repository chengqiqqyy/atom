var demo = new Vue({
    el: '#demo',
    data: {
      items: [
        { key: 1, color: '#ffebcc'},
        { key: 2, color: '#ffb86c'},
        { key: 3, color: '#f01b2d'}
      ],

    	dragging: null
    },

  	methods: {
      handleDragStart(e, item) {
        this.dragging = item
      },

      handleDragEnd() {
        this.dragging = null
      },

      handleDragEnter(e, item) {
        e.dataTransfer.effectAllowed = 'move'

        if (item === this.dragging) {
          return
        }

        const newItems = [...this.items]
        const src = newItems.indexOf(this.dragging)
        const dst = newItems.indexOf(item)

        newItems.splice(dst, 0, ...newItems.splice(src, 1))

        this.items = newItems
      },

      handleDragOver(e) {
        e.dataTransfer.dropEffect = 'move'
      },

       handleDrop() {
      },
    }
})
