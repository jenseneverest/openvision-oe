RDEPENDS_${PN}-testtools = "python python-dbus ${@bb.utils.contains('GI_DATA_ENABLED', 'True', 'python-pygobject', '', d)}"
