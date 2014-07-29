#ifndef FAKE_IFACE_H_
#define FAKE_IFACE_H_

#include <glib-object.h>

#define FAKE_TYPE_ICLIENT       ( fake_iclient_get_type() )
#define FAKE_ICLIENT(obj)       ( G_TYPE_CHECK_INSTANCE_CAST((obj), FAKE_TYPE_ICLIENT, FakeIClient) )
#define FAKE_IS_ICLIENT(obj)    ( G_TYPE_CHECK_INSTANCE_TYPE((obj), FAKE_TYPE_ICLIENT) )
#define FAKE_ICLIENT_GET_INTERFACE(inst)  \
    ( G_TYPE_INSTANCE_GET_INTERFACE((inst), FAKE_TYPE_ICLIENT, FakeIClientInterface) )

#define FAKE_TYPE_ISERVER       ( fake_iserver_get_type() )
#define FAKE_ISERVER(obj)       ( G_TYPE_CHECK_INSTANCE_CAST((obj), FAKE_TYPE_ISERVER, FakeIServer) )
#define FAKE_IS_ISERVER(obj)    ( G_TYPE_CHECK_INSTANCE_TYPE((obj), FAKE_TYPE_ISERVER) )
#define FAKE_ISERVER_GET_INTERFACE(inst)  \
    ( G_TYPE_INSTANCE_GET_INTERFACE((inst), FAKE_TYPE_ISERVER, FakeIServerInterface) )

typedef struct _FakeIClient FakeIClient; /* dummy object */
typedef struct _FakeIClientInterface {
    GTypeInterface parent;
    void (*request)(FakeIClient *instance);
} FakeIClientInterface;

typedef struct _FakeIServer FakeIServer; /* dummy object */
typedef struct _FakeIServerInterface {
    GTypeInterface parent;
    void (*response)(FakeIServer *instance);
} FakeIServerInterface;

GType fake_iclient_get_type();
GType fake_iserver_get_type();

void fake_iclient_request(FakeIClient *instance);
void fake_iserver_response(FakeIServer *instance);


#endif /* FAKE_IFACE_H_ */
